package com.ygbc.brain.business.management.service.participant_pool_chart;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.CreateParticipantPoolChartReqDTO;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class ParticipantPoolChartCreateService extends BaseExecutableService<Req<CreateParticipantPoolChartReqDTO>,Resp>{
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Resp execute(@Valid Req<CreateParticipantPoolChartReqDTO> req) throws Exception {
        CreateParticipantPoolChartReqDTO reqDTO = req.getData();
        ParticipantPoolChartData participantPoolChartData = DeepBeanUtils.copyAs(reqDTO,ParticipantPoolChartData.class);
        if(participantPoolChartData != null){
            participantPoolChartData.setParticipantPoolChartId(IdWorker.getFlowIdWorkerInstance().nextId());
            Platform.sdbInsert(participantPoolChartData);
        }
        return Resp.build();
    }
}
