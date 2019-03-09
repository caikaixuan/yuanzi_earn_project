package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.SysParameterServiceFacade;
import com.ygbc.brain.business.management.api.dto.sys_parameter.*;
import com.ygbc.brain.business.management.api.model.SysParameterModel;
import com.ygbc.brain.business.management.service.sys_parameter.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysParameterServiceFacadeImpl implements SysParameterServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<SysParameterModel>> list(Req<QuerySysParameterListReqDTO> req) {
        SysParameterListService service = SpringUtils.getBean(SysParameterListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<SysParameterModel> detail(Req<QuerySysParameterDetailReqDTO> req) {
        SysParameterDetailService service = SpringUtils.getBean(SysParameterDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateSysParameterReqDTO> req) {
        SysParameterCreateService service = SpringUtils.getBean(SysParameterCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteSysParameterReqDTO> req) {
        SysParameterDeleteService service = SpringUtils.getBean(SysParameterDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateSysParameterReqDTO> req) {
        SysParameterUpdateService service = SpringUtils.getBean(SysParameterUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
