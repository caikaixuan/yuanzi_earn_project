package com.ygbc.brain.business.management.service.charge_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.charge_record.UpdateChargeRecordReqDTO;
import com.ygbc.brain.business.management.api.model.ChargeRecordModel;
import com.ygbc.brain.business.common.dal.data.ChargeRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class ChargeRecordUpdateService extends BaseExecutableService<Req<UpdateChargeRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateChargeRecordReqDTO> req) throws Exception {
        UpdateChargeRecordReqDTO reqDTO = req.getData();
        ChargeRecordData chargeRecordData = Platform.sdbRead(ChargeRecordData.class,reqDTO.getChargeRecordId());
        if(chargeRecordData == null){
            return Resp.build(ChargeRecordModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,chargeRecordData);
            Platform.sdbUpdate(chargeRecordData);
            return Resp.build();
        }
    }
}
