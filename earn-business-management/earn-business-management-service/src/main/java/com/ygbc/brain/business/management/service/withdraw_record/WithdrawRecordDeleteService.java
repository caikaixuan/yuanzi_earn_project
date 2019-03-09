package com.ygbc.brain.business.management.service.withdraw_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.withdraw_record.DeleteWithdrawRecordReqDTO;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;
import com.ygbc.brain.business.common.dal.data.WithdrawRecordData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class WithdrawRecordDeleteService extends BaseExecutableService<Req<DeleteWithdrawRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteWithdrawRecordValidator.class)
    public Resp execute(@Valid Req<DeleteWithdrawRecordReqDTO> req) throws Exception {
        WithdrawRecordData withdrawRecordData = Platform.sdbRead(WithdrawRecordData.class,req.getData().getWithdrawRecordId());
        if(withdrawRecordData == null){
            return Resp.build(WithdrawRecordModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            withdrawRecordData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(withdrawRecordData);
            return Resp.build();
        }
    }
}
