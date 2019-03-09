package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.QuestionServiceFacade;
import com.ygbc.brain.business.management.api.dto.question.*;
import com.ygbc.brain.business.management.api.model.ChallengeModel;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import com.ygbc.brain.business.management.service.question.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceFacadeImpl implements QuestionServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<QuestionModel>> list(Req<QueryQuestionListReqDTO> req) {
        QuestionListService service = SpringUtils.getBean(QuestionListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<QuestionModel> detail(Req<QueryQuestionDetailReqDTO> req) {
        QuestionDetailService service = SpringUtils.getBean(QuestionDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateQuestionReqDTO> req) {
        QuestionCreateService service = SpringUtils.getBean(QuestionCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteQuestionReqDTO> req) {
        QuestionDeleteService service = SpringUtils.getBean(QuestionDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateQuestionReqDTO> req) {
        QuestionUpdateService service = SpringUtils.getBean(QuestionUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<ChallengeModel> getChallenge(Req<GetChallengeReqDTO> req) {
        GetChallengeService service = SpringUtils.getBean(GetChallengeService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

}
