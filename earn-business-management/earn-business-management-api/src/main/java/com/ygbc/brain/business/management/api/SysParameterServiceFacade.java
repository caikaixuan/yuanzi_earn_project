package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.sys_parameter.*;
import com.ygbc.brain.business.management.api.model.SysParameterModel;

import java.util.List;

public interface SysParameterServiceFacade {
    Resp<List<SysParameterModel>> list(Req<QuerySysParameterListReqDTO> req);

    Resp<SysParameterModel> detail(Req<QuerySysParameterDetailReqDTO> req);

    Resp create(Req<CreateSysParameterReqDTO> req);

    Resp delete(Req<DeleteSysParameterReqDTO> req);

    Resp update(Req<UpdateSysParameterReqDTO> req);
}
