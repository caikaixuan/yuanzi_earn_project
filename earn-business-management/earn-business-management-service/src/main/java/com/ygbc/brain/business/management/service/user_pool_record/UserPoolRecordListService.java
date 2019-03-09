package com.ygbc.brain.business.management.service.user_pool_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.user_pool_record.QueryUserPoolRecordListReqDTO;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserPoolRecordListService extends BaseExecutableService<Req<QueryUserPoolRecordListReqDTO>,Resp<List<UserPoolRecordModel>>>{
    @Override
    public Resp<List<UserPoolRecordModel>> execute(@Valid Req<QueryUserPoolRecordListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        UserPoolRecordData userPoolRecordData = DeepBeanUtils.copyAs(req.getData(), UserPoolRecordData.class);
        int total = Platform.dbCount(userPoolRecordData);
        List<UserPoolRecordModel> userPoolRecordModelList = null;
        if (total > 0) {
            List<UserPoolRecordData> userPoolRecordDataList = Platform.dbReadSet(userPoolRecordData, page, req.getSortField(), req.getSortType());
            userPoolRecordModelList = DeepBeanUtils.copyAs(userPoolRecordDataList, UserPoolRecordModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, userPoolRecordModelList);
    }
}
