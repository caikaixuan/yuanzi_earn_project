package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.InviteNumberServiceFacade;
import com.ygbc.brain.business.management.api.dto.invite_number.*;
import com.ygbc.brain.business.management.api.model.InviteNumberModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inviteNumber")
@Api(value = "/inviteNumber", tags = "", description = "邀请码管理")
public class InviteNumberController {
    @Autowired
    private InviteNumberServiceFacade inviteNumberServiceFacade;

    @ApiOperation(value = "获取邀请码列表", notes = "获取邀请码列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<InviteNumberModel>> list(@RequestBody Req<QueryInviteNumberListReqDTO> req) {
        return inviteNumberServiceFacade.list(req);
    }

    @ApiOperation(value = "获取邀请码列表", notes = "获取邀请码列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<InviteNumberModel> detail(@RequestBody Req<QueryInviteNumberDetailReqDTO> req) {
        return inviteNumberServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取邀请码列表", notes = "获取邀请码列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateInviteNumberReqDTO> req) {
        return inviteNumberServiceFacade.create(req);
    }

    @ApiOperation(value = "获取邀请码列表", notes = "获取邀请码列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateInviteNumberReqDTO> req) {
        return inviteNumberServiceFacade.update(req);
    }

    @ApiOperation(value = "获取邀请码列表", notes = "获取邀请码列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteInviteNumberReqDTO> req) {
        return inviteNumberServiceFacade.delete(req);
    }
}
