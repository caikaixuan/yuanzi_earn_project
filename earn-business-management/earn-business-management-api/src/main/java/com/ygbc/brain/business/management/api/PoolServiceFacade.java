package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.pool.*;
import com.ygbc.brain.business.management.api.model.PoolModel;

import java.util.List;

public interface PoolServiceFacade {
    Resp<List<PoolModel>> list(Req<QueryPoolListReqDTO> req);

    Resp<PoolModel> detail(Req<QueryPoolDetailReqDTO> req);

    Resp<PoolModel> create(Req<CreatePoolReqDTO> req);

    Resp delete(Req<DeletePoolReqDTO> req);

    Resp update(Req<UpdatePoolReqDTO> req);

    Resp<PoolModel> getCurrentPool(Req<GetCurrentPoolReqDTO> req);

    Resp<List<PoolModel>> getCurrentPools(Req<GetCurrentPoolsReqDTO> req);

    Resp runLotteryInAdvance(Req<RunLotteryInAdvanceReqDTO> req);
}
