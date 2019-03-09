package com.ygbc.brain.business.management.service.user_pool_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user_pool_record.QueryUserPoolRecordDetailReqDTO;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserPoolRecordDetailService extends BaseExecutableService<Req<QueryUserPoolRecordDetailReqDTO>,Resp<UserPoolRecordModel>>{
    @Override
    public Resp<UserPoolRecordModel> execute(@Valid Req<QueryUserPoolRecordDetailReqDTO> req) throws Exception {
        UserPoolRecordData userPoolRecordData = Platform.sdbRead(UserPoolRecordData.class,req.getData().getUserPoolRecordId());
        if (userPoolRecordData == null) {
            return Resp.build(UserPoolRecordModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(userPoolRecordData, UserPoolRecordModel.class));
        }
    }
}
