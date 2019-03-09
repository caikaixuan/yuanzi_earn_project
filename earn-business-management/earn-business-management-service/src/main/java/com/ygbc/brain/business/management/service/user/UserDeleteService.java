package com.ygbc.brain.business.management.service.user;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user.DeleteUserReqDTO;
import com.ygbc.brain.business.management.api.model.UserModel;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class UserDeleteService extends BaseExecutableService<Req<DeleteUserReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteUserValidator.class)
    public Resp execute(@Valid Req<DeleteUserReqDTO> req) throws Exception {
        UserData userData = Platform.sdbRead(UserData.class,req.getData().getUserId());
        if(userData == null){
            return Resp.build(UserModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            userData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(userData);
            return Resp.build();
        }
    }
}
