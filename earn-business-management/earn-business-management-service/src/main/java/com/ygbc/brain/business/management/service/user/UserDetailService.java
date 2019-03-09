package com.ygbc.brain.business.management.service.user;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user.QueryUserDetailReqDTO;
import com.ygbc.brain.business.management.api.model.UserModel;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserDetailService extends BaseExecutableService<Req<QueryUserDetailReqDTO>,Resp<UserModel>>{
    @Override
    public Resp<UserModel> execute(@Valid Req<QueryUserDetailReqDTO> req) throws Exception {
        UserData userData = Platform.sdbRead(UserData.class,req.getData().getUserId());
        if (userData == null) {
            return Resp.build(UserModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(userData, UserModel.class));
        }
    }
}
