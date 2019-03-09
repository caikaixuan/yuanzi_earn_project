package com.ygbc.brain.business.management.service.withdraw_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.withdraw_record.QueryWithdrawRecordDetailReqDTO;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;
import com.ygbc.brain.business.common.dal.data.WithdrawRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class WithdrawRecordDetailService extends BaseExecutableService<Req<QueryWithdrawRecordDetailReqDTO>,Resp<WithdrawRecordModel>>{
    @Override
    public Resp<WithdrawRecordModel> execute(@Valid Req<QueryWithdrawRecordDetailReqDTO> req) throws Exception {
        WithdrawRecordData withdrawRecordData = Platform.sdbRead(WithdrawRecordData.class,req.getData().getWithdrawRecordId());
        if (withdrawRecordData == null) {
            return Resp.build(WithdrawRecordModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(withdrawRecordData, WithdrawRecordModel.class));
        }
    }
}
