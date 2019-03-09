package com.ygbc.brain.business.management.service.invite_number;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.invite_number.UpdateInviteNumberReqDTO;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;
import com.ygbc.brain.business.common.dal.data.InviteNumberData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class InviteNumberUpdateService extends BaseExecutableService<Req<UpdateInviteNumberReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateInviteNumberReqDTO> req) throws Exception {
        UpdateInviteNumberReqDTO reqDTO = req.getData();
        InviteNumberData inviteNumberChartData = Platform.sdbRead(InviteNumberData.class,reqDTO.getInviteNumberId());
        if(inviteNumberChartData == null){
            return Resp.build(InviteNumberModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,inviteNumberChartData);
            Platform.sdbUpdate(inviteNumberChartData);
            return Resp.build();
        }
    }
}
