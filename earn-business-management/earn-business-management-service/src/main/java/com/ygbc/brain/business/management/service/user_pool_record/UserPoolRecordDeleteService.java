package com.ygbc.brain.business.management.service.user_pool_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user_pool_record.DeleteUserPoolRecordReqDTO;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class UserPoolRecordDeleteService extends BaseExecutableService<Req<DeleteUserPoolRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteUserPoolRecordValidator.class)
    public Resp execute(@Valid Req<DeleteUserPoolRecordReqDTO> req) throws Exception {
        UserPoolRecordData userPoolRecordData = Platform.sdbRead(UserPoolRecordData.class,req.getData().getUserPoolRecordId());
        if(userPoolRecordData == null){
            return Resp.build(UserPoolRecordModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            userPoolRecordData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(userPoolRecordData);
            return Resp.build();
        }
    }
}
