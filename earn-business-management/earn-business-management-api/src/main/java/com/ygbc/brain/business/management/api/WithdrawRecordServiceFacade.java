package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.withdraw_record.*;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;

import java.util.List;

public interface WithdrawRecordServiceFacade {
    Resp<List<WithdrawRecordModel>> list(Req<QueryWithdrawRecordListReqDTO> req);

    Resp<WithdrawRecordModel> detail(Req<QueryWithdrawRecordDetailReqDTO> req);

    Resp create(Req<CreateWithdrawRecordReqDTO> req);

    Resp delete(Req<DeleteWithdrawRecordReqDTO> req);

    Resp update(Req<UpdateWithdrawRecordReqDTO> req);
}
