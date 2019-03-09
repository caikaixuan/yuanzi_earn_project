package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.ChargeRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.charge_record.*;
import com.ygbc.brain.business.management.api.model.ChargeRecordModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chargeRecord")
@Api(value = "/chargeRecord", tags = "", description = "充值记录管理")
public class ChargeRecordController {
    @Autowired
    private ChargeRecordServiceFacade chartRecordServiceFacade;

    @ApiOperation(value = "获取充值记录列表", notes = "获取充值记录列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<ChargeRecordModel>> list(@RequestBody Req<QueryChargeRecordListReqDTO> req) {
        return chartRecordServiceFacade.list(req);
    }

    @ApiOperation(value = "获取充值记录列表", notes = "获取充值记录列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<ChargeRecordModel> detail(@RequestBody Req<QueryChargeRecordDetailReqDTO> req) {
        return chartRecordServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取充值记录列表", notes = "获取充值记录列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateChargeRecordReqDTO> req) {
        return chartRecordServiceFacade.create(req);
    }

    @ApiOperation(value = "获取充值记录列表", notes = "获取充值记录列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateChargeRecordReqDTO> req) {
        return chartRecordServiceFacade.update(req);
    }

    @ApiOperation(value = "获取充值记录列表", notes = "获取充值记录列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteChargeRecordReqDTO> req) {
        return chartRecordServiceFacade.delete(req);
    }
}
