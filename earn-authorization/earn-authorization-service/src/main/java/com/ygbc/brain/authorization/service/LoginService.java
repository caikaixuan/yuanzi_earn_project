package com.ygbc.brain.authorization.service;

import com.ygbc.brain.authorization.api.Constants.AuthorConstants;
import com.ygbc.brain.authorization.api.dto.LoginReqDTO;
import com.ygbc.brain.authorization.api.dto.LoginRespDTO;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.business.common.enums.UserStatus;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.common.session.RedisSessionManager;
import com.ygbc.brain.common.token.annotation.NoLogin;
import com.ygbc.brain.common.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.MapSession;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends BaseExecutableService<Req<LoginReqDTO>, Resp<LoginRespDTO>> {

    @Autowired
    private RedisSessionManager redisSessionManager;

    @NoLogin
    @Override
    public Resp<LoginRespDTO> execute(Req<LoginReqDTO> req) throws Exception {
        Resp<LoginRespDTO> resp = new Resp<>();
        LoginReqDTO loginReqDTO = req.getData();
        UserData userData = Platform.sdbRead(UserData.class, loginReqDTO.getLoginName());
        if (userData == null) {
            return Resp.build(LoginRespDTO.class, AuthorConstants.INVALID_USER_OR_PASSWORD_ERROR_CODE, AuthorConstants.INVALID_USER_OR_PASSWORD_ERROR_MSG);
        }
        if (userData.getStatus() == UserStatus.FROZEN.getValue()) {
            return Resp.build(LoginRespDTO.class, AuthorConstants.INVALID_USER_STATUS_ERROR_CODE, AuthorConstants.INVALID_USER_STATUS_ERROR_MSG);
        }
        if (!PasswordUtils.verify(loginReqDTO.getPassword(), userData.getPassword())) {
            return Resp.build(LoginRespDTO.class, AuthorConstants.INVALID_USER_OR_PASSWORD_ERROR_CODE, AuthorConstants.INVALID_USER_OR_PASSWORD_ERROR_MSG);
        }
        LoginRespDTO loginRespDTO = new LoginRespDTO();
        MapSession session = redisSessionManager.doReadSession(loginReqDTO.getLoginName());
        if (session == null) {
            session = new MapSession();
            loginRespDTO.setSessionId(session.getId());
            redisSessionManager.doCreate(loginReqDTO.getLoginName(), session);
        } else {
            loginRespDTO.setSessionId(session.getId());
            redisSessionManager.doUpdate(loginReqDTO.getLoginName(), session);
        }
        resp.setData(loginRespDTO);
        return resp;
    }
}
