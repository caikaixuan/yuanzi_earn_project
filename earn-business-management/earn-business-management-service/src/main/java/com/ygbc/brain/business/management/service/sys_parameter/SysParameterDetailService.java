package com.ygbc.brain.business.management.service.sys_parameter;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.sys_parameter.QuerySysParameterDetailReqDTO;
import com.ygbc.brain.business.management.api.model.SysParameterModel;
import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SysParameterDetailService extends BaseExecutableService<Req<QuerySysParameterDetailReqDTO>,Resp<SysParameterModel>>{
    @Override
    public Resp<SysParameterModel> execute(@Valid Req<QuerySysParameterDetailReqDTO> req) throws Exception {
        SysParameterData data = Platform.sdbRead(SysParameterData.class,req.getData().getId());
        if (data == null) {
            return Resp.build(SysParameterModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(data, SysParameterModel.class));
        }
    }
}
