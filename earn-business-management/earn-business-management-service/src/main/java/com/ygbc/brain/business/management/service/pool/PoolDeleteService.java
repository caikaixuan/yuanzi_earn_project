package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.DeletePoolReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class PoolDeleteService extends BaseExecutableService<Req<DeletePoolReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeletePoolValidator.class)
    public Resp execute(@Valid Req<DeletePoolReqDTO> req) throws Exception {
        PoolData poolData = Platform.sdbRead(PoolData.class,req.getData().getPoolId());
        if(poolData == null){
            return Resp.build(PoolModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            poolData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(poolData);
            return Resp.build();
        }
    }
}
