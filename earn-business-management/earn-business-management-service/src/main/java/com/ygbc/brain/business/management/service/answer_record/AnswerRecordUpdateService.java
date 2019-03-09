package com.ygbc.brain.business.management.service.answer_record;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.answer_record.UpdateAnswerRecordReqDTO;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;
import com.ygbc.brain.business.common.dal.data.AnswerRecordData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class AnswerRecordUpdateService extends BaseExecutableService<Req<UpdateAnswerRecordReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateAnswerRecordReqDTO> req) throws Exception {
        UpdateAnswerRecordReqDTO reqDTO = req.getData();
        AnswerRecordData answerRecordData = Platform.sdbRead(AnswerRecordData.class,reqDTO.getAnswerRecordId());
        if(answerRecordData == null){
            return Resp.build(AnswerRecordModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,answerRecordData);
            Platform.sdbUpdate(answerRecordData);
            return Resp.build();
        }
    }
}
