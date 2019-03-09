package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.ParticipantPoolChartServiceFacade;
import com.ygbc.brain.business.management.api.dto.participant_pool_chart.*;
import com.ygbc.brain.business.management.api.model.ParticipantPoolChartModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("participantPoolChart")
@Api(value = "/participantPoolChart", tags = "", description = "参与人排行管理")
public class ParticipantPoolChartController {
    @Autowired
    private ParticipantPoolChartServiceFacade participantPoolChartServiceFacade;

    @ApiOperation(value = "获取参与人排行列表", notes = "获取参与人排行列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<ParticipantPoolChartModel>> list(@RequestBody Req<QueryParticipantPoolChartListReqDTO> req) {
        return participantPoolChartServiceFacade.list(req);
    }

    @ApiOperation(value = "获取参与人排行列表", notes = "获取参与人排行列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<ParticipantPoolChartModel> detail(@RequestBody Req<QueryParticipantPoolChartDetailReqDTO> req) {
        return participantPoolChartServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取参与人排行列表", notes = "获取参与人排行列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateParticipantPoolChartReqDTO> req) {
        return participantPoolChartServiceFacade.create(req);
    }

    @ApiOperation(value = "获取参与人排行列表", notes = "获取参与人排行列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateParticipantPoolChartReqDTO> req) {
        return participantPoolChartServiceFacade.update(req);
    }

    @ApiOperation(value = "获取参与人排行列表", notes = "获取参与人排行列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteParticipantPoolChartReqDTO> req) {
        return participantPoolChartServiceFacade.delete(req);
    }
}
