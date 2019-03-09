package com.ygbc.brain.business.management.service.invite_number;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.invite_number.CreateInviteNumberReqDTO;
import com.ygbc.brain.business.common.dal.data.InviteNumberData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class InviteNumberCreateService extends BaseExecutableService<Req<CreateInviteNumberReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateInviteNumberReqDTO> req) throws Exception {
        CreateInviteNumberReqDTO reqDTO = req.getData();
        InviteNumberData inviteNumberData = DeepBeanUtils.copyAs(reqDTO,InviteNumberData.class);
        if(inviteNumberData != null){
            inviteNumberData.setInviteNumberId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(inviteNumberData);
        }
        return Resp.build();
    }
}
