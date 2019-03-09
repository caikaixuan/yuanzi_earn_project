package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.UserServiceFacade;
import com.ygbc.brain.business.management.api.dto.user.*;
import com.ygbc.brain.business.management.api.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(value = "/topic", tags = "", description = "用户管理")
public class UserController {
    @Autowired
    private UserServiceFacade userServiceFacade;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<UserModel>> list(@RequestBody Req<QueryUserListReqDTO> req) {
        return userServiceFacade.list(req);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<UserModel> detail(@RequestBody Req<QueryUserDetailReqDTO> req) {
        return userServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateUserReqDTO> req) {
        return userServiceFacade.create(req);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateUserReqDTO> req) {
        return userServiceFacade.update(req);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteUserReqDTO> req) {
        return userServiceFacade.delete(req);
    }
}
