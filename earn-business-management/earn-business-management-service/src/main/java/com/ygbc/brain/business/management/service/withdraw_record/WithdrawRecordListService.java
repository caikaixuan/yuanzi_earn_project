package com.ygbc.brain.business.management.service.withdraw_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.withdraw_record.QueryWithdrawRecordListReqDTO;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;
import com.ygbc.brain.business.common.dal.data.WithdrawRecordData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class WithdrawRecordListService extends BaseExecutableService<Req<QueryWithdrawRecordListReqDTO>,Resp<List<WithdrawRecordModel>>>{
    @Override
    public Resp<List<WithdrawRecordModel>> execute(@Valid Req<QueryWithdrawRecordListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        WithdrawRecordData withdrawRecordData = DeepBeanUtils.copyAs(req.getData(), WithdrawRecordData.class);
        int total = Platform.dbCount(withdrawRecordData);
        List<WithdrawRecordModel> withdrawRecordModelList = null;
        if (total > 0) {
            List<WithdrawRecordData> withdrawRecordDataList = Platform.dbReadSet(withdrawRecordData, page, req.getSortField(), req.getSortType());
            withdrawRecordModelList = DeepBeanUtils.copyAs(withdrawRecordDataList, WithdrawRecordModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, withdrawRecordModelList);
    }
}
