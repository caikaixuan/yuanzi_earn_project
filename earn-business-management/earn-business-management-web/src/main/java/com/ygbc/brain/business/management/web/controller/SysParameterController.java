package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.SysParameterServiceFacade;
import com.ygbc.brain.business.management.api.dto.sys_parameter.*;
import com.ygbc.brain.business.management.api.model.SysParameterModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sysParameter")
@Api(value = "/sysParameter", tags = "", description = "系统参数管理")
public class SysParameterController {
    @Autowired
    private SysParameterServiceFacade sysParameterServiceFacade;

    @ApiOperation(value = "获取系统参数列表", notes = "获取系统参数列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<SysParameterModel>> list(@RequestBody Req<QuerySysParameterListReqDTO> req) {
        return sysParameterServiceFacade.list(req);
    }

    @ApiOperation(value = "获取系统参数列表", notes = "获取系统参数列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<SysParameterModel> detail(@RequestBody Req<QuerySysParameterDetailReqDTO> req) {
        return sysParameterServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取系统参数列表", notes = "获取系统参数列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateSysParameterReqDTO> req) {
        return sysParameterServiceFacade.create(req);
    }

    @ApiOperation(value = "获取系统参数列表", notes = "获取系统参数列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateSysParameterReqDTO> req) {
        return sysParameterServiceFacade.update(req);
    }

    @ApiOperation(value = "获取系统参数列表", notes = "获取系统参数列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteSysParameterReqDTO> req) {
        return sysParameterServiceFacade.delete(req);
    }
}
