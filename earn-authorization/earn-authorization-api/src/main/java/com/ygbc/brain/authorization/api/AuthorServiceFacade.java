package com.ygbc.brain.authorization.api;

import com.ygbc.brain.authorization.api.dto.LoadUserRespDTO;
import com.ygbc.brain.authorization.api.dto.LoginReqDTO;
import com.ygbc.brain.authorization.api.dto.LoginRespDTO;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;

public interface AuthorServiceFacade {

    //RpcResp register(RpcReq req);

    Resp<LoginRespDTO> login(Req<LoginReqDTO> req);

    Resp<LoadUserRespDTO> loadUser(Req req);

    Resp logout(Req req);
}
