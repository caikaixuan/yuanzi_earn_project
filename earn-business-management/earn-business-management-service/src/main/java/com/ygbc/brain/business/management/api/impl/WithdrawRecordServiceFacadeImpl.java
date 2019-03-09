package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.WithdrawRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.withdraw_record.*;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;
import com.ygbc.brain.business.management.service.withdraw_record.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawRecordServiceFacadeImpl implements WithdrawRecordServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<WithdrawRecordModel>> list(Req<QueryWithdrawRecordListReqDTO> req) {
        WithdrawRecordListService service = SpringUtils.getBean(WithdrawRecordListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<WithdrawRecordModel> detail(Req<QueryWithdrawRecordDetailReqDTO> req) {
        WithdrawRecordDetailService service = SpringUtils.getBean(WithdrawRecordDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateWithdrawRecordReqDTO> req) {
        WithdrawRecordCreateService service = SpringUtils.getBean(WithdrawRecordCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteWithdrawRecordReqDTO> req) {
        WithdrawRecordDeleteService service = SpringUtils.getBean(WithdrawRecordDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateWithdrawRecordReqDTO> req) {
        WithdrawRecordUpdateService service = SpringUtils.getBean(WithdrawRecordUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
