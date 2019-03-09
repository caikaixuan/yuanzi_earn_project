package com.ygbc.brain.business.management.service.participant_pool_chart;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.business.common.service.base.BaseExecutableService;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.QueryParticipantPoolChartListReqDTO;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.common.model.Page;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ParticipantPoolChartListService extends BaseExecutableService<Req<QueryParticipantPoolChartListReqDTO>,Resp<List<ParticipantPoolChartModel>>>{
    @Override
    public Resp<List<ParticipantPoolChartModel>> execute(@Valid Req<QueryParticipantPoolChartListReqDTO> req) throws Exception {
        Page page = new Page(req.getPageNo(), req.getPageSize());
        ParticipantPoolChartData data = DeepBeanUtils.copyAs(req.getData(), ParticipantPoolChartData.class);
        int total = Platform.dbCount(data);
        List<ParticipantPoolChartModel> participantPoolChartModelList = null;
        if (total > 0) {
            List<ParticipantPoolChartData> participantPoolChartDataList = Platform.dbReadSet(data, page, req.getSortField(), req.getSortType());
            participantPoolChartModelList = DeepBeanUtils.copyAs(participantPoolChartDataList, ParticipantPoolChartModel.class);
        }
        return Resp.build(page.getPageNo(), page.getPageSize(), total, participantPoolChartModelList);
    }
}
