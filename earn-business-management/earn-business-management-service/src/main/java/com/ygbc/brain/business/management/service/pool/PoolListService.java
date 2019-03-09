package com.ygbc.brain.business.management.service.pool;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.pool.QueryPoolListReqDTO;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PoolListService extends BaseExecutableService<Req<QueryPoolListReqDTO>,Resp<List<PoolModel>>>{
    @Override
    public Resp<List<PoolModel>> execute(@Valid Req<QueryPoolListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        PoolData poolData = DeepBeanUtils.copyAs(req.getData(), PoolData.class);
        int total = Platform.dbCount(poolData);
        List<PoolModel> poolModelList = null;
        if (total > 0) {
            List<PoolData> poolDataList = Platform.dbReadSet(poolData, page, req.getSortField(), req.getSortType());
            poolModelList = DeepBeanUtils.copyAs(poolDataList, PoolModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, poolModelList);
    }
}
