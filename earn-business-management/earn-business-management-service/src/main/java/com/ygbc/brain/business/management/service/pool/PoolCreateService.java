package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.CreatePoolReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class PoolCreateService extends BaseExecutableService<Req<CreatePoolReqDTO>,Resp<PoolModel>>{

    @Autowired
    private PoolProcessor processor;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp<PoolModel> execute(@Valid Req<CreatePoolReqDTO> req) throws Exception {
        PoolData poolData = processor.beginNewPool().getData();
        return Resp.build(DeepBeanUtils.copyAs(poolData,PoolModel.class));
    }
}
