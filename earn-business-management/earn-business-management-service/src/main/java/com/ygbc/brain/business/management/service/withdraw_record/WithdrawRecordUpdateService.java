package com.ygbc.brain.business.management.service.withdraw_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.withdraw_record.UpdateWithdrawRecordReqDTO;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;
import com.ygbc.brain.business.common.dal.data.WithdrawRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class WithdrawRecordUpdateService extends BaseExecutableService<Req<UpdateWithdrawRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateWithdrawRecordReqDTO> req) throws Exception {
        UpdateWithdrawRecordReqDTO reqDTO = req.getData();
        WithdrawRecordData withdrawRecordData = Platform.sdbRead(WithdrawRecordData.class,reqDTO.getWithdrawRecordId());
        if(withdrawRecordData == null){
            return Resp.build(WithdrawRecordModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,withdrawRecordData);
            Platform.sdbUpdate(withdrawRecordData);
            return Resp.build();
        }
    }
}
