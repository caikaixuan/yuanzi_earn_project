package com.ygbc.brain.business.management.service.answer_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.answer_record.DeleteAnswerRecordReqDTO;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;
import com.ygbc.brain.business.common.dal.data.AnswerRecordData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class AnswerRecordDeleteService extends BaseExecutableService<Req<DeleteAnswerRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteAnswerRecordValidator.class)
    public Resp execute(@Valid Req<DeleteAnswerRecordReqDTO> req) throws Exception {
        AnswerRecordData answerRecordData = Platform.sdbRead(AnswerRecordData.class,req.getData().getAnswerRecordId());
        if(answerRecordData == null){
            return Resp.build(AnswerRecordModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            answerRecordData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(answerRecordData);
            return Resp.build();
        }
    }
}
