package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.*;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;

import java.util.List;

public interface ParticipantPoolChartServiceFacade {
    Resp<List<ParticipantPoolChartModel>> list(Req<QueryParticipantPoolChartListReqDTO> req);

    Resp<ParticipantPoolChartModel> detail(Req<QueryParticipantPoolChartDetailReqDTO> req);

    Resp create(Req<CreateParticipantPoolChartReqDTO> req);

    Resp delete(Req<DeleteParticipantPoolChartReqDTO> req);

    Resp update(Req<UpdateParticipantPoolChartReqDTO> req);
}
