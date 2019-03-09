package com.ygbc.brain.business.management.service.answer_record;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.answer_record.CreateAnswerRecordReqDTO;
import com.ygbc.brain.business.common.dal.data.AnswerRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class AnswerRecordCreateService extends BaseExecutableService<Req<CreateAnswerRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateAnswerRecordReqDTO> req) throws Exception {
        CreateAnswerRecordReqDTO reqDTO = req.getData();
        AnswerRecordData answerRecordData = DeepBeanUtils.copyAs(reqDTO,AnswerRecordData.class);
        if(answerRecordData != null){
            answerRecordData.setAnswerRecordId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(answerRecordData);
        }
        return Resp.build();
    }
}
