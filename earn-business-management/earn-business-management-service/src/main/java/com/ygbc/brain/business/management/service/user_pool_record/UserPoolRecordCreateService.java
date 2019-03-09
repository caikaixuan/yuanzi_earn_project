package com.ygbc.brain.business.management.service.user_pool_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.AnswerRecordData;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.answer_record.CreateAnswerRecordReqDTO;
import com.ygbc.brain.business.management.api.dto.user_pool_record.CreateUserPoolRecordReqDTO;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserPoolRecordCreateService extends BaseExecutableService<Req<CreateUserPoolRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateUserPoolRecordReqDTO> req) throws Exception {
        CreateUserPoolRecordReqDTO reqDTO = req.getData();
        UserPoolRecordData userPoolRecordData = DeepBeanUtils.copyAs(reqDTO,UserPoolRecordData.class);
        if(userPoolRecordData != null){
            userPoolRecordData.setUserPoolRecordId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(userPoolRecordData);
            List<CreateAnswerRecordReqDTO> answerRecordReqDTOS = reqDTO.getAnswerRecords();
            for(CreateAnswerRecordReqDTO answerRecordReqDTO : answerRecordReqDTOS){
                AnswerRecordData answerRecord = DeepBeanUtils.copyAs(answerRecordReqDTO,AnswerRecordData.class);
                answerRecord.setAnswerRecordId(IdWorker.getFlowIdWorkerInstance().nextId());
                Platform.sdbInsert(answerRecord);
            }
        }
        return Resp.build();
    }
}
