package com.ygbc.brain.business.management.service.question;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.constants.BusinessConstants;
import com.ygbc.brain.business.common.dal.data.QuestionData;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.UserPoolRecord;
import com.ygbc.brain.business.common.enums.PoolProcessorEvent;
import com.ygbc.brain.business.common.enums.PoolStatus;
import com.ygbc.brain.business.common.enums.UserPoolRecordStatus;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.question.GetChallengeReqDTO;
import com.ygbc.brain.business.management.api.model.ChallengeModel;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import com.ygbc.brain.business.management.validator.QuestionValidator;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import com.ygbc.brain.common.validate.annotation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class GetChallengeService extends BaseExecutableService<Req<GetChallengeReqDTO>,Resp<ChallengeModel>> {

    @Autowired
    private PoolProcessor processor;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Validator(className = QuestionValidator.class,includes = {"poolId"})
    public Resp<ChallengeModel> execute(Req<GetChallengeReqDTO> req) throws Exception {
        GetChallengeReqDTO reqDTO = req.getData();
        Pool pool = processor.getPool(reqDTO.getPoolId());
        if(pool.canChallenge()){
            return Resp.build(Constants.POOL_STATUS_VALIDATE_CODE,Constants.POOL_STATUS_VALIDATE_DESC);
        }
        List<QuestionModel> questionModelList;
        if(needSuccess(reqDTO)){
            questionModelList = getEasyQuestions(reqDTO);
        }else{
            questionModelList = getHardQuestions(reqDTO);
        }
        consumeIntegration(reqDTO);
        UserPoolRecord userPoolRecord = createRecord(reqDTO);
        pool.put(BusinessConstants.ATTR_POOL_RECORD,userPoolRecord);
        processor.notify(pool, PoolProcessorEvent.POOL_NEW_RECORD_START);
        return Resp.build(new ChallengeModel(questionModelList,userPoolRecord.getUserPoolRecordId()));
    }

    private boolean needSuccess(GetChallengeReqDTO reqDTO) {
        return false;
    }

    private List<QuestionModel> getEasyQuestions(GetChallengeReqDTO reqDTO) throws Exception {
        Page page = new Page(1,BusinessConstants.CHALLENGE_SIZE);
        List<QuestionData> questionDataList = Platform.dbReadSet(new QuestionData(),page,BusinessConstants.CHALLENGE_SORT_FIELD_DIFFICULTY,BusinessConstants.DEFAULT_SORT_TYPE);
        return DeepBeanUtils.copyAs(questionDataList,QuestionModel.class);
    }

    private List<QuestionModel> getHardQuestions(GetChallengeReqDTO reqDTO) throws Exception {
        Page page = new Page(1,BusinessConstants.CHALLENGE_SIZE);
        List<QuestionData> questionDataList = Platform.dbReadSet(new QuestionData(),page,BusinessConstants.CHALLENGE_SORT_FIELD_DIFFICULTY,BusinessConstants.DEFAULT_SORT_TYPE);
        return DeepBeanUtils.copyAs(questionDataList,QuestionModel.class);
    }

    private UserData consumeIntegration(GetChallengeReqDTO reqDTO)throws Exception{
        if(reqDTO.getUserId() != null){
            UserData user = Platform.sdbRead(UserData.class,reqDTO.getUserId());
            user.setIntegration(user.getIntegration() - reqDTO.getConsumeIntegration());
            Platform.sdbUpdate(user);
            return user;
        }
        return null;
    }

    private UserPoolRecord createRecord(GetChallengeReqDTO reqDTO) throws Exception {
        if(reqDTO.getUserId() != null){
            long userPoolRecordId = IdWorker.getFlowIdWorkerInstance().nextId();
            UserPoolRecordData record = new UserPoolRecordData();
            record.setUserPoolRecordId(userPoolRecordId);
            record.setPoolId(reqDTO.getPoolId());
            record.setUserId(reqDTO.getUserId());
            record.setUserNickName(reqDTO.getUserNickName());
            record.setConsumeIntegration(reqDTO.getConsumeIntegration());
            record.setRightNum(0);
            record.setResult(false);
            record.setCreateTime(new Date());
            record.setStatus(UserPoolRecordStatus.INEFFECTIVE.getValue());
            Platform.sdbInsert(record);
            return new UserPoolRecord(record);
        }
        return null;
    }


}
