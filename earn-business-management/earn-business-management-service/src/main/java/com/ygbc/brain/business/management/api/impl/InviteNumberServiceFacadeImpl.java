package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.InviteNumberServiceFacade;
import com.ygbc.brain.business.management.api.dto.invite_number.*;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;
import com.ygbc.brain.business.management.service.invite_number.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteNumberServiceFacadeImpl implements InviteNumberServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<InviteNumberModel>> list(Req<QueryInviteNumberListReqDTO> req) {
        InviteNumberListService service = SpringUtils.getBean(InviteNumberListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<InviteNumberModel> detail(Req<QueryInviteNumberDetailReqDTO> req) {
        InviteNumberDetailService service = SpringUtils.getBean(InviteNumberDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateInviteNumberReqDTO> req) {
        InviteNumberCreateService service = SpringUtils.getBean(InviteNumberCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteInviteNumberReqDTO> req) {
        InviteNumberDeleteService service = SpringUtils.getBean(InviteNumberDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateInviteNumberReqDTO> req) {
        InviteNumberUpdateService service = SpringUtils.getBean(InviteNumberUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
