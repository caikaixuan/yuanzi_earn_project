package com.ygbc.brain.business.management.service.answer_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.answer_record.QueryAnswerRecordListReqDTO;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;
import com.ygbc.brain.business.common.dal.data.AnswerRecordData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class AnswerRecordListService extends BaseExecutableService<Req<QueryAnswerRecordListReqDTO>,Resp<List<AnswerRecordModel>>>{
    @Override
    public Resp<List<AnswerRecordModel>> execute(@Valid Req<QueryAnswerRecordListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        AnswerRecordData answerRecordData = DeepBeanUtils.copyAs(req.getData(), AnswerRecordData.class);
        int total = Platform.dbCount(answerRecordData);
        List<AnswerRecordModel> answerRecordModelList = null;
        if (total > 0) {
            List<AnswerRecordData> answerRecordDataList = Platform.dbReadSet(answerRecordData, page, req.getSortField(), req.getSortType());
            answerRecordModelList = DeepBeanUtils.copyAs(answerRecordDataList, AnswerRecordModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, answerRecordModelList);
    }
}
