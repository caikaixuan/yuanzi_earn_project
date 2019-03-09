package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.topic.*;
import com.ygbc.brain.business.management.api.model.TopicModel;

import java.util.List;

public interface TopicServiceFacade {
    Resp<List<TopicModel>> list(Req<QueryTopicListReqDTO> req);

    Resp<TopicModel> detail(Req<QueryTopicDetailReqDTO> req);

    Resp create(Req<CreateTopicReqDTO> req);

    Resp delete(Req<DeleteTopicReqDTO> req);

    Resp update(Req<UpdateTopicReqDTO> req);
}
