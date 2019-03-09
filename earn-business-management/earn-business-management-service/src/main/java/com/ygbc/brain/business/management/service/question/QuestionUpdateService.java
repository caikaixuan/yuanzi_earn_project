package com.ygbc.brain.business.management.service.question;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.question.UpdateQuestionReqDTO;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import com.ygbc.brain.business.common.dal.data.QuestionData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class QuestionUpdateService extends BaseExecutableService<Req<UpdateQuestionReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateQuestionReqDTO> req) throws Exception {
        UpdateQuestionReqDTO reqDTO = req.getData();
        QuestionData questionData = Platform.sdbRead(QuestionData.class,reqDTO.getQuestionId());
        if(questionData == null){
            return Resp.build(QuestionModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,questionData);
            Platform.sdbUpdate(questionData);
            return Resp.build();
        }
    }
}
