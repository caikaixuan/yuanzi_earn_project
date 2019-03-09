package com.ygbc.brain.business.management.service.user;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user.QueryUserListReqDTO;
import com.ygbc.brain.business.management.api.model.UserModel;
import com.ygbc.brain.business.common.dal.data.UserData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserListService extends BaseExecutableService<Req<QueryUserListReqDTO>,Resp<List<UserModel>>>{
    @Override
    public Resp<List<UserModel>> execute(@Valid Req<QueryUserListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        UserData userData = DeepBeanUtils.copyAs(req.getData(), UserData.class);
        int total = Platform.dbCount(userData);
        List<UserModel> userModelList = null;
        if (total > 0) {
            List<UserData> userDataList = Platform.dbReadSet(userData, page, req.getSortField(), req.getSortType());
            userModelList = DeepBeanUtils.copyAs(userDataList, UserModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, userModelList);
    }
}
