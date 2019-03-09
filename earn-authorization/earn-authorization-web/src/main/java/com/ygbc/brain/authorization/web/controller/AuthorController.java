package com.ygbc.brain.authorization.web.controller;

import com.ygbc.brain.authorization.api.AuthorServiceFacade;
import com.ygbc.brain.authorization.api.dto.LoadUserRespDTO;
import com.ygbc.brain.authorization.api.dto.LoginReqDTO;
import com.ygbc.brain.authorization.api.dto.LoginRespDTO;
import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authorization")
public class AuthorController {

    @Autowired
    private AuthorServiceFacade authorServiceFacade;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Resp<LoginRespDTO> login(@RequestBody Req<LoginReqDTO> req) {
        return authorServiceFacade.login(req);
    }

    @RequestMapping(value = "/loadUser", method = RequestMethod.POST)
    public Resp<LoadUserRespDTO> loadUser(@RequestBody Req req) {
        return authorServiceFacade.loadUser(req);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Resp logout(@RequestBody Req req) {
        return authorServiceFacade.logout(req);
    }
}
