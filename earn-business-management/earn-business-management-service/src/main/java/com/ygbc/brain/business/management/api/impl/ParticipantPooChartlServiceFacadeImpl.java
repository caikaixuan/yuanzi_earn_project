package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.ParticipantPoolChartServiceFacade;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.*;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;
import com.ygbc.brain.business.management.service.participant_pool_chart.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantPooChartlServiceFacadeImpl implements ParticipantPoolChartServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<ParticipantPoolChartModel>> list(Req<QueryParticipantPoolChartListReqDTO> req) {
        ParticipantPoolChartListService service = SpringUtils.getBean(ParticipantPoolChartListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<ParticipantPoolChartModel> detail(Req<QueryParticipantPoolChartDetailReqDTO> req) {
        ParticipantPoolChartDetailService service = SpringUtils.getBean(ParticipantPoolChartDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateParticipantPoolChartReqDTO> req) {
        ParticipantPoolChartCreateService service = SpringUtils.getBean(ParticipantPoolChartCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteParticipantPoolChartReqDTO> req) {
        ParticipantPoolChartDeleteService service = SpringUtils.getBean(ParticipantPoolChartDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateParticipantPoolChartReqDTO> req) {
        ParticipantPoolChartUpdateService service = SpringUtils.getBean(ParticipantPoolChartUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
