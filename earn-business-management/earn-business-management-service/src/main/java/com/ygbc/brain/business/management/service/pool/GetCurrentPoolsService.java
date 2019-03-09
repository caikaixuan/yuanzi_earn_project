package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.GetCurrentPoolsReqDTO;
import com.ygbc.brain.business.management.api.dto.pool.QueryPoolDetailReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCurrentPoolsService extends BaseExecutableService<Req<GetCurrentPoolsReqDTO>,Resp<List<PoolModel>>>{
    @Autowired
    private PoolProcessor processor;

    @Override
    public Resp<List<PoolModel>> execute(Req<GetCurrentPoolsReqDTO> req) throws Exception {
        List<Pool> poolList  = processor.getPools();
        List<PoolData> poolDataList = new ArrayList<>();
        for(Pool pool : poolList){
            poolDataList.add(pool.getData());
        }
        return Resp.build(DeepBeanUtils.copyAs(poolDataList, PoolModel.class));
    }
}
