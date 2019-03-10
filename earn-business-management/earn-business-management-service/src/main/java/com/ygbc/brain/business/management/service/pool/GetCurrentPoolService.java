package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.GetCurrentPoolReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentPoolService extends BaseExecutableService<Req<GetCurrentPoolReqDTO>,Resp<PoolModel>>{
    @Autowired
    private PoolProcessor processor;

    @Override
    public Resp<PoolModel> execute(Req<GetCurrentPoolReqDTO> req) throws Exception {
        Long poolId = req.getData().getPoolId();
        Pool pool = null;
        if(poolId != null){
            pool = processor.getPool(poolId);
        }else{
            pool = processor.getPool();
        }
        if (pool == null) {
            return Resp.build(PoolModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(pool.getData(), PoolModel.class));
        }
    }
}
