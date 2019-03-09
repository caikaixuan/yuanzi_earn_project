package com.ygbc.brain.business.management.service.participant_pool_chart;

import com.ygbc.brain.base.constants.Constants;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.QueryParticipantPoolChartDetailReqDTO;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ParticipantPoolChartDetailService extends BaseExecutableService<Req<QueryParticipantPoolChartDetailReqDTO>,Resp<ParticipantPoolChartModel>>{
    @Override
    public Resp<ParticipantPoolChartModel> execute(@Valid Req<QueryParticipantPoolChartDetailReqDTO> req) throws Exception {
        ParticipantPoolChartData data = Platform.sdbRead(ParticipantPoolChartData.class,req.getData().getParticipantPoolChartId());
        if (data == null) {
            return Resp.build(ParticipantPoolChartModel.class, Constants.PARAM_RESULTBLANK_CODE, Constants.PARAM_RESULTBLANK_DESC);
        } else {
            return Resp.build(DeepBeanUtils.copyAs(data, ParticipantPoolChartModel.class));
        }
    }
}
