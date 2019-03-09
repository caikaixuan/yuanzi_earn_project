package com.ygbc.brain.business.management.service.withdraw_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.withdraw_record.CreateWithdrawRecordReqDTO;
import com.ygbc.brain.business.common.dal.data.WithdrawRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class WithdrawRecordCreateService extends BaseExecutableService<Req<CreateWithdrawRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateWithdrawRecordReqDTO> req) throws Exception {
        CreateWithdrawRecordReqDTO reqDTO = req.getData();
        WithdrawRecordData withdrawRecordData = DeepBeanUtils.copyAs(reqDTO,WithdrawRecordData.class);
        if(withdrawRecordData != null){
            withdrawRecordData.setWithdrawRecordId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(withdrawRecordData);
        }
        return Resp.build();
    }
}
