package com.ygbc.brain.business.management.service.sys_parameter;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.sys_parameter.CreateSysParameterReqDTO;
import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class SysParameterCreateService extends BaseExecutableService<Req<CreateSysParameterReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateSysParameterReqDTO> req) throws Exception {
        CreateSysParameterReqDTO reqDTO = req.getData();
        SysParameterData sysParameterData = DeepBeanUtils.copyAs(reqDTO,SysParameterData.class);
        if(sysParameterData != null){
            Platform.sdbInsert(sysParameterData);
        }
        return Resp.build();
    }
}
