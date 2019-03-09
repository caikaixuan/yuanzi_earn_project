package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.user_pool_record.*;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;

import java.util.List;

public interface UserPoolRecordServiceFacade {
    Resp<List<UserPoolRecordModel>> list(Req<QueryUserPoolRecordListReqDTO> req);

    Resp<UserPoolRecordModel> detail(Req<QueryUserPoolRecordDetailReqDTO> req);

    Resp create(Req<CreateUserPoolRecordReqDTO> req);

    Resp delete(Req<DeleteUserPoolRecordReqDTO> req);

    Resp update(Req<UpdateUserPoolRecordReqDTO> req);

    Resp submit(Req<SubmitRecordResultReqDTO> req);
}
