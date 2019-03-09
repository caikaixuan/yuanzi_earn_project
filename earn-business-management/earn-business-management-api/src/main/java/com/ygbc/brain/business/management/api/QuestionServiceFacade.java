package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.question.*;
import com.ygbc.brain.business.management.api.model.ChallengeModel;
import com.ygbc.brain.business.management.api.model.QuestionModel;

import java.util.List;

public interface QuestionServiceFacade {
    Resp<List<QuestionModel>> list(Req<QueryQuestionListReqDTO> req);

    Resp<QuestionModel> detail(Req<QueryQuestionDetailReqDTO> req);

    Resp create(Req<CreateQuestionReqDTO> req);

    Resp delete(Req<DeleteQuestionReqDTO> req);

    Resp update(Req<UpdateQuestionReqDTO> req);

    Resp<ChallengeModel> getChallenge(Req<GetChallengeReqDTO> req);

}
