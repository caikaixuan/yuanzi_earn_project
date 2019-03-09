package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.answer_record.*;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;

import java.util.List;

public interface AnswerRecordServiceFacade {
    Resp<List<AnswerRecordModel>> list(Req<QueryAnswerRecordListReqDTO> req);

    Resp<AnswerRecordModel> detail(Req<QueryAnswerRecordDetailReqDTO> req);

    Resp create(Req<CreateAnswerRecordReqDTO> req);

    Resp delete(Req<DeleteAnswerRecordReqDTO> req);

    Resp update(Req<UpdateAnswerRecordReqDTO> req);
}
