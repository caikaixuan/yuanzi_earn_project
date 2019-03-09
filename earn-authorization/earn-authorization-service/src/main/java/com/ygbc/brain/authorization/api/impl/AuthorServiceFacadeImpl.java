package com.ygbc.brain.authorization.api.impl;

import com.ygbc.brain.authorization.api.AuthorServiceFacade;
import com.ygbc.brain.authorization.api.dto.LoadUserRespDTO;
import com.ygbc.brain.authorization.api.dto.LoginReqDTO;
import com.ygbc.brain.authorization.api.dto.LoginRespDTO;
import com.ygbc.brain.authorization.service.LoadUserService;
import com.ygbc.brain.authorization.service.LoginService;
import com.ygbc.brain.authorization.service.LogoutService;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class AuthorServiceFacadeImpl implements AuthorServiceFacade {

    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<LoginRespDTO> login(Req<LoginReqDTO> req) {
        try {
            LoginService service = SpringUtils.getBean(LoginService.class);
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<LoadUserRespDTO> loadUser(Req req) {
        try {
            LoadUserService service = SpringUtils.getBean(LoadUserService.class);
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp logout(Req req) {
        try {
            LogoutService service = SpringUtils.getBean(LogoutService.class);
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
