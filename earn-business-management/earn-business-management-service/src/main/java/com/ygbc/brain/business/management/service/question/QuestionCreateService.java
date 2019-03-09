package com.ygbc.brain.business.management.service.question;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.question.CreateQuestionReqDTO;
import com.ygbc.brain.business.common.dal.data.QuestionData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class QuestionCreateService extends BaseExecutableService<Req<CreateQuestionReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateQuestionReqDTO> req) throws Exception {
        CreateQuestionReqDTO reqDTO = req.getData();
        QuestionData questionData = DeepBeanUtils.copyAs(reqDTO,QuestionData.class);
        if(questionData != null){
            questionData.setQuestionId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(questionData);
        }
        return Resp.build();
    }
}
