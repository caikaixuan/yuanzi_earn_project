package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.enums.PoolStatus;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.RunLotteryInAdvanceReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunLotteryInAdvanceService extends BaseExecutableService<Req<RunLotteryInAdvanceReqDTO>,Resp> {
    @Autowired
    private PoolProcessor processor;

    @Override
    public Resp execute(Req<RunLotteryInAdvanceReqDTO> req) throws Exception {
        RunLotteryInAdvanceReqDTO reqDTO = req.getData();
        Pool pool = processor.getPool(reqDTO.getPoolId());
        pool.setStatus(PoolStatus.LOCKED.getValue());
        return Resp.build();
    }
}
