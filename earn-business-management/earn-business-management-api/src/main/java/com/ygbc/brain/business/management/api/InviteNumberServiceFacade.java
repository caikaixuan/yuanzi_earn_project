package com.ygbc.brain.business.management.api;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.dto.invite_number.*;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;

import java.util.List;

public interface InviteNumberServiceFacade {
    Resp<List<InviteNumberModel>> list(Req<QueryInviteNumberListReqDTO> req);

    Resp<InviteNumberModel> detail(Req<QueryInviteNumberDetailReqDTO> req);

    Resp create(Req<CreateInviteNumberReqDTO> req);

    Resp delete(Req<DeleteInviteNumberReqDTO> req);

    Resp update(Req<UpdateInviteNumberReqDTO> req);
}
