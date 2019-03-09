package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.charge_record.*;
import com.ygbc.brain.business.management.api.model.ChargeRecordModel;

import java.util.List;

public interface ChargeRecordServiceFacade {
    Resp<List<ChargeRecordModel>> list(Req<QueryChargeRecordListReqDTO> req);

    Resp<ChargeRecordModel> detail(Req<QueryChargeRecordDetailReqDTO> req);

    Resp create(Req<CreateChargeRecordReqDTO> req);

    Resp delete(Req<DeleteChargeRecordReqDTO> req);

    Resp update(Req<UpdateChargeRecordReqDTO> req);
}
