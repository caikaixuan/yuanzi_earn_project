package com.ygbc.brain.business.management.service.invite_number;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.invite_number.DeleteInviteNumberReqDTO;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;
import com.ygbc.brain.business.common.dal.data.InviteNumberData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class InviteNumberDeleteService extends BaseExecutableService<Req<DeleteInviteNumberReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteInviteNumberValidator.class)
    public Resp execute(@Valid Req<DeleteInviteNumberReqDTO> req) throws Exception {
        InviteNumberData inviteNumberData = Platform.sdbRead(InviteNumberData.class,req.getData().getInviteNumberId());
        if(inviteNumberData == null){
            return Resp.build(InviteNumberModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            inviteNumberData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(inviteNumberData);
            return Resp.build();
        }
    }
}
