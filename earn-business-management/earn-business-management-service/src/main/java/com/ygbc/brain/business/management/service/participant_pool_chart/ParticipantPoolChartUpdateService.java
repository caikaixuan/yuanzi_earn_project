package com.ygbc.brain.business.management.service.participant_pool_chart;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.UpdateParticipantPoolChartReqDTO;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class ParticipantPoolChartUpdateService extends BaseExecutableService<Req<UpdateParticipantPoolChartReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<UpdateParticipantPoolChartReqDTO> req) throws Exception {
        UpdateParticipantPoolChartReqDTO reqDTO = req.getData();
        ParticipantPoolChartData participantPoolChartData = Platform.sdbRead(ParticipantPoolChartData.class,reqDTO.getParticipantPoolChartId());
        if(participantPoolChartData == null){
            return Resp.build(ParticipantPoolChartModel.class, Constants.PARAM_RESULTBLANK_CODE,Constants.PARAM_RESULTBLANK_DESC);
        }else{
            DeepBeanUtils.copyNotNullProperties(reqDTO,participantPoolChartData);
            Platform.sdbUpdate(participantPoolChartData);
            return Resp.build();
        }
    }
}
