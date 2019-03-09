package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.UserServiceFacade;
import com.ygbc.brain.business.management.api.dto.user.*;
import com.ygbc.brain.business.management.api.model.UserModel;
import com.ygbc.brain.business.management.service.user.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<UserModel>> list(Req<QueryUserListReqDTO> req) {
        UserListService service = SpringUtils.getBean(UserListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<UserModel> detail(Req<QueryUserDetailReqDTO> req) {
        UserDetailService service = SpringUtils.getBean(UserDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateUserReqDTO> req) {
        UserCreateService service = SpringUtils.getBean(UserCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteUserReqDTO> req) {
        UserDeleteService service = SpringUtils.getBean(UserDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateUserReqDTO> req) {
        UserUpdateService service = SpringUtils.getBean(UserUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
