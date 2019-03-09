package com.ygbc.brain.business.management.service.sys_parameter;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.sys_parameter.QuerySysParameterListReqDTO;
import com.ygbc.brain.business.management.api.model.SysParameterModel;
import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class SysParameterListService extends BaseExecutableService<Req<QuerySysParameterListReqDTO>,Resp<List<SysParameterModel>>>{
    @Override
    public Resp<List<SysParameterModel>> execute(@Valid Req<QuerySysParameterListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        SysParameterData data = DeepBeanUtils.copyAs(req.getData(), SysParameterData.class);
        int total = Platform.dbCount(data);
        List<SysParameterModel> poolModelList = null;
        if (total > 0) {
            List<SysParameterData> poolDataList = Platform.dbReadSet(data, page, req.getSortField(), req.getSortType());
            poolModelList = DeepBeanUtils.copyAs(poolDataList, SysParameterModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, poolModelList);
    }
}
