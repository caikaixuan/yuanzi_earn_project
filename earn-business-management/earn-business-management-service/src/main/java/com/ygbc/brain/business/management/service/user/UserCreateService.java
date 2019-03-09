package com.ygbc.brain.business.management.service.user;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user.CreateUserReqDTO;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class UserCreateService extends BaseExecutableService<Req<CreateUserReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateUserReqDTO> req) throws Exception {
        CreateUserReqDTO reqDTO = req.getData();
        UserData userData = DeepBeanUtils.copyAs(reqDTO,UserData.class);
        if(userData != null){
            userData.setUserId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(userData);
        }
        return Resp.build();
    }
}
