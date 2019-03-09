package com.ygbc.brain.business.management.service.invite_number;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.invite_number.QueryInviteNumberDetailReqDTO;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;
import com.ygbc.brain.business.common.dal.data.InviteNumberData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class InviteNumberDetailService extends BaseExecutableService<Req<QueryInviteNumberDetailReqDTO>,Resp<InviteNumberModel>>{
    @Override
    public Resp<InviteNumberModel> execute(@Valid Req<QueryInviteNumberDetailReqDTO> req) throws Exception {
        InviteNumberData inviteNumberData = Platform.sdbRead(InviteNumberData.class,req.getData().getInviteNumberId());
        if (inviteNumberData == null) {
            return Resp.build(InviteNumberModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(inviteNumberData, InviteNumberModel.class));
        }
    }
}
