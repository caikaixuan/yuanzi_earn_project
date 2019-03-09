package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.user.*;
import com.ygbc.brain.business.management.api.model.UserModel;

import java.util.List;

public interface UserServiceFacade {
    Resp<List<UserModel>> list(Req<QueryUserListReqDTO> req);

    Resp<UserModel> detail(Req<QueryUserDetailReqDTO> req);

    Resp create(Req<CreateUserReqDTO> req);

    Resp delete(Req<DeleteUserReqDTO> req);

    Resp update(Req<UpdateUserReqDTO> req);
}
