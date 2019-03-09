package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.ChargeRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.charge_record.*;
import com.ygbc.brain.business.management.api.model.ChargeRecordModel;
import com.ygbc.brain.business.management.service.charge_record.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeRecordServiceFacadeImpl implements ChargeRecordServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<ChargeRecordModel>> list(Req<QueryChargeRecordListReqDTO> req) {
        ChargeRecordListService service = SpringUtils.getBean(ChargeRecordListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<ChargeRecordModel> detail(Req<QueryChargeRecordDetailReqDTO> req) {
        ChargeRecordDetailService service = SpringUtils.getBean(ChargeRecordDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateChargeRecordReqDTO> req) {
        ChargeRecordCreateService service = SpringUtils.getBean(ChargeRecordCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteChargeRecordReqDTO> req) {
        ChargeRecordDeleteService service = SpringUtils.getBean(ChargeRecordDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateChargeRecordReqDTO> req) {
        ChargeRecordUpdateService service = SpringUtils.getBean(ChargeRecordUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
