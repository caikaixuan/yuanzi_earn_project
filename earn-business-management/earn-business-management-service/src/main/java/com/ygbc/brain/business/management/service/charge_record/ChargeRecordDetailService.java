package com.ygbc.brain.business.management.service.charge_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.charge_record.QueryChargeRecordDetailReqDTO;
import com.ygbc.brain.business.management.api.model.ChargeRecordModel;
import com.ygbc.brain.business.common.dal.data.ChargeRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ChargeRecordDetailService extends BaseExecutableService<Req<QueryChargeRecordDetailReqDTO>,Resp<ChargeRecordModel>>{
    @Override
    public Resp<ChargeRecordModel> execute(@Valid Req<QueryChargeRecordDetailReqDTO> req) throws Exception {
        ChargeRecordData chargeRecordData = Platform.sdbRead(ChargeRecordData.class,req.getData().getChargeRecordId());
        if (chargeRecordData == null) {
            return Resp.build(ChargeRecordModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(chargeRecordData, ChargeRecordModel.class));
        }
    }
}
