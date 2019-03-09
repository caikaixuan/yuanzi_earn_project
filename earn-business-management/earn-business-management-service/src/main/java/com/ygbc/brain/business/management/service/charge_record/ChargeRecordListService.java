package com.ygbc.brain.business.management.service.charge_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.charge_record.QueryChargeRecordListReqDTO;
import com.ygbc.brain.business.management.api.model.ChargeRecordModel;
import com.ygbc.brain.business.common.dal.data.ChargeRecordData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ChargeRecordListService extends BaseExecutableService<Req<QueryChargeRecordListReqDTO>,Resp<List<ChargeRecordModel>>>{
    @Override
    public Resp<List<ChargeRecordModel>> execute(@Valid Req<QueryChargeRecordListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        ChargeRecordData chargeRecordData = DeepBeanUtils.copyAs(req.getData(), ChargeRecordData.class);
        int total = Platform.dbCount(chargeRecordData);
        List<ChargeRecordModel> chargeRecordModelList = null;
        if (total > 0) {
            List<ChargeRecordData> chargeRecordDataList = Platform.dbReadSet(chargeRecordData, page, req.getSortField(), req.getSortType());
            chargeRecordModelList = DeepBeanUtils.copyAs(chargeRecordDataList, ChargeRecordModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, chargeRecordModelList);
    }
}
