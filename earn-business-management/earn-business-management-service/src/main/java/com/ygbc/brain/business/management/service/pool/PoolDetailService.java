package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.QueryPoolDetailReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class PoolDetailService extends BaseExecutableService<Req<QueryPoolDetailReqDTO>,Resp<PoolModel>>{
    @Override
    public Resp<PoolModel> execute(@Valid Req<QueryPoolDetailReqDTO> req) throws Exception {
        PoolData poolData = Platform.sdbRead(PoolData.class,req.getData().getPoolId());
        if (poolData == null) {
            return Resp.build(PoolModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(poolData, PoolModel.class));
        }
    }
}
