package com.ygbc.brain.business.management.service.user;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user.UpdateUserReqDTO;
import com.ygbc.brain.business.management.api.model.UserModel;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class UserUpdateService extends BaseExecutableService<Req<UpdateUserReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateUserReqDTO> req) throws Exception {
        UpdateUserReqDTO reqDTO = req.getData();
        UserData userData = Platform.sdbRead(UserData.class,reqDTO.getUserId());
        if(userData == null){
            return Resp.build(UserModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,userData);
            Platform.sdbUpdate(userData);
            return Resp.build();
        }
    }
}
