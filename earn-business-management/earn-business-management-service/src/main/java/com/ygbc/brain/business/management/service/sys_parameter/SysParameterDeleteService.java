package com.ygbc.brain.business.management.service.sys_parameter;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.sys_parameter.DeleteSysParameterReqDTO;
import com.ygbc.brain.business.management.api.model.SysParameterModel;
import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class SysParameterDeleteService extends BaseExecutableService<Req<DeleteSysParameterReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteSysParameterValidator.class)
    public Resp execute(@Valid Req<DeleteSysParameterReqDTO> req) throws Exception {
        SysParameterData sysParameterData = Platform.sdbRead(SysParameterData.class,req.getData().getId());
        if(sysParameterData == null){
            return Resp.build(SysParameterModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            sysParameterData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(sysParameterData);
            return Resp.build();
        }
    }
}
