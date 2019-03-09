package com.ygbc.brain.business.management.service.question;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.question.DeleteQuestionReqDTO;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import com.ygbc.brain.business.common.dal.data.QuestionData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class QuestionDeleteService extends BaseExecutableService<Req<DeleteQuestionReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteQuestionValidator.class)
    public Resp execute(@Valid Req<DeleteQuestionReqDTO> req) throws Exception {
        QuestionData questionData = Platform.sdbRead(QuestionData.class,req.getData().getQuestionId());
        if(questionData == null){
            return Resp.build(QuestionModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            questionData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(questionData);
            return Resp.build();
        }
    }
}
