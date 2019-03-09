package com.ygbc.brain.business.management.service.participant_pool_chart;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.DeleteParticipantPoolChartReqDTO;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.enums.YesNo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class ParticipantPoolChartDeleteService extends BaseExecutableService<Req<DeleteParticipantPoolChartReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
//    @Validator(className = DeleteParticipantPoolChartValidator.class)
    public Resp execute(@Valid Req<DeleteParticipantPoolChartReqDTO> req) throws Exception {
        ParticipantPoolChartData participantPoolChartData = Platform.sdbRead(ParticipantPoolChartData.class,req.getData().getParticipantPoolChartId());
        if(participantPoolChartData == null){
            return Resp.build(ParticipantPoolChartModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            participantPoolChartData.setIsDel(TrueFalse.TRUE.getValue());
            Platform.sdbUpdate(participantPoolChartData);
            return Resp.build();
        }
    }
}
