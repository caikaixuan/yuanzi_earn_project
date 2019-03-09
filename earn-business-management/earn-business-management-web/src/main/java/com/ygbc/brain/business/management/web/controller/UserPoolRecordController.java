package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.UserPoolRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.user_pool_record.*;
import com.ygbc.brain.business.management.api.model.UserPoolRecordModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userPoolRecord")
@Api(value = "/userPoolRecord", tags = "", description = "奖池参与记录管理")
public class UserPoolRecordController {
    @Autowired
    private UserPoolRecordServiceFacade userPoolRecordServiceFacade;

    @ApiOperation(value = "获取奖池参与记录列表", notes = "获取奖池参与记录列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<UserPoolRecordModel>> list(@RequestBody Req<QueryUserPoolRecordListReqDTO> req) {
        return userPoolRecordServiceFacade.list(req);
    }

    @ApiOperation(value = "获取奖池参与记录列表", notes = "获取奖池参与记录列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<UserPoolRecordModel> detail(@RequestBody Req<QueryUserPoolRecordDetailReqDTO> req) {
        return userPoolRecordServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取奖池参与记录列表", notes = "获取奖池参与记录列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateUserPoolRecordReqDTO> req) {
        return userPoolRecordServiceFacade.create(req);
    }

    @ApiOperation(value = "获取奖池参与记录列表", notes = "获取奖池参与记录列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateUserPoolRecordReqDTO> req) {
        return userPoolRecordServiceFacade.update(req);
    }

    @ApiOperation(value = "获取奖池参与记录列表", notes = "获取奖池参与记录列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteUserPoolRecordReqDTO> req) {
        return userPoolRecordServiceFacade.delete(req);
    }

    @ApiOperation(value = "发送挑战结果", notes = "发送挑战结果", httpMethod = "POST")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Resp sbumit(@RequestBody Req<SubmitRecordResultReqDTO> req) {
        return userPoolRecordServiceFacade.submit(req);
    }
}
