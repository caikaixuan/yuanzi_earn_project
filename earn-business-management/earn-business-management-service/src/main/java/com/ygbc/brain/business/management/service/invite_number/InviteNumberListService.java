package com.ygbc.brain.business.management.service.invite_number;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.invite_number.QueryInviteNumberListReqDTO;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;
import com.ygbc.brain.business.common.dal.data.InviteNumberData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class InviteNumberListService extends BaseExecutableService<Req<QueryInviteNumberListReqDTO>,Resp<List<InviteNumberModel>>>{
    @Override
    public Resp<List<InviteNumberModel>> execute(@Valid Req<QueryInviteNumberListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        InviteNumberData inviteNumberData = DeepBeanUtils.copyAs(req.getData(), InviteNumberData.class);
        int total = Platform.dbCount(inviteNumberData);
        List<InviteNumberModel> inviteNumberModelList = null;
        if (total > 0) {
            List<InviteNumberData> inviteNumberDataList = Platform.dbReadSet(inviteNumberData, page, req.getSortField(), req.getSortType());
            inviteNumberModelList = DeepBeanUtils.copyAs(inviteNumberDataList, InviteNumberModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, inviteNumberModelList);
    }
}
