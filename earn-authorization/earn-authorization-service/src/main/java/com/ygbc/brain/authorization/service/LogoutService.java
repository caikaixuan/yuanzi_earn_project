package com.ygbc.brain.authorization.service;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.common.session.RedisSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.MapSession;
import org.springframework.stereotype.Service;

@Service
public class LogoutService extends BaseExecutableService<Req, Resp> {

    @Autowired
    private RedisSessionManager redisSessionManager;

    @Override
    public Resp execute(Req req) throws Exception {
        MapSession session = redisSessionManager.doReadSession(req.getLoginName());
        if (session != null) {
            if (session.getId().equals(req.getSessionId())) {
                redisSessionManager.doDelete(req.getLoginName());
            } else {
                return Resp.build(Constants.INVALID_TOKEN_ERROR_CODE, Constants.INVALID_TOKEN_ERROR_MSG);
            }
        }
        return Resp.build();
    }
}
