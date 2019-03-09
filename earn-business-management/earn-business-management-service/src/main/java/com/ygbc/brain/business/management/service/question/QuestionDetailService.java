package com.ygbc.brain.business.management.service.question;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.question.QueryQuestionDetailReqDTO;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import com.ygbc.brain.business.common.dal.data.QuestionData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class QuestionDetailService extends BaseExecutableService<Req<QueryQuestionDetailReqDTO>,Resp<QuestionModel>>{
    @Override
    public Resp<QuestionModel> execute(@Valid Req<QueryQuestionDetailReqDTO> req) throws Exception {
        QuestionData questionData = Platform.sdbRead(QuestionData.class,req.getData().getQuestionId());
        if (questionData == null) {
            return Resp.build(QuestionModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(questionData, QuestionModel.class));
        }
    }
}
