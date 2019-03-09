package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.UpdatePoolReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class PoolUpdateService extends BaseExecutableService<Req<UpdatePoolReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdatePoolReqDTO> req) throws Exception {
        UpdatePoolReqDTO reqDTO = req.getData();
        PoolData poolData = Platform.sdbRead(PoolData.class,reqDTO.getPoolId());
        if(poolData == null){
            return Resp.build(PoolModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,poolData);
            Platform.sdbUpdate(poolData);
            return Resp.build();
        }
    }
}
