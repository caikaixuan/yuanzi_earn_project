package com.ygbc.brain.business.management.service.answer_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.answer_record.QueryAnswerRecordDetailReqDTO;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;
import com.ygbc.brain.business.common.dal.data.AnswerRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class AnswerRecordDetailService extends BaseExecutableService<Req<QueryAnswerRecordDetailReqDTO>,Resp<AnswerRecordModel>>{
    @Override
    public Resp<AnswerRecordModel> execute(@Valid Req<QueryAnswerRecordDetailReqDTO> req) throws Exception {
        AnswerRecordData answerRecordData = Platform.sdbRead(AnswerRecordData.class,req.getData().getAnswerRecordId());
        if (answerRecordData == null) {
            return Resp.build(AnswerRecordModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(answerRecordData, AnswerRecordModel.class));
        }
    }
}
