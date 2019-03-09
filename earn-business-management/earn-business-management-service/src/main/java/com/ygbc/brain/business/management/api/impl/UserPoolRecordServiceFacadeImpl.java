package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.UserPoolRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.user_pool_record.*;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;
import com.ygbc.brain.business.management.service.user_pool_record.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPoolRecordServiceFacadeImpl implements UserPoolRecordServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<UserPoolRecordModel>> list(Req<QueryUserPoolRecordListReqDTO> req) {
        UserPoolRecordListService service = SpringUtils.getBean(UserPoolRecordListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<UserPoolRecordModel> detail(Req<QueryUserPoolRecordDetailReqDTO> req) {
        UserPoolRecordDetailService service = SpringUtils.getBean(UserPoolRecordDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateUserPoolRecordReqDTO> req) {
        UserPoolRecordCreateService service = SpringUtils.getBean(UserPoolRecordCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteUserPoolRecordReqDTO> req) {
        UserPoolRecordDeleteService service = SpringUtils.getBean(UserPoolRecordDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateUserPoolRecordReqDTO> req) {
        UserPoolRecordUpdateService service = SpringUtils.getBean(UserPoolRecordUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp submit(Req<SubmitRecordResultReqDTO> req) {
        SubmitRecordResultService service = SpringUtils.getBean(SubmitRecordResultService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
