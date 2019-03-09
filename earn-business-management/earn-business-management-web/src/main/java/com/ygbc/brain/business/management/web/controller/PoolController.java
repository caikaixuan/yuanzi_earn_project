package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.management.api.PoolServiceFacade;
import com.ygbc.brain.business.management.api.dto.pool.*;
import com.ygbc.brain.business.management.api.model.PoolModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pool")
@Api(value = "/pool", tags = "", description = "奖池管理")

public class PoolController {
    @Autowired
    private PoolServiceFacade poolServiceFacade;

    @ApiOperation(value = "获取奖池列表", notes = "获取奖池列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<PoolModel>> list(@RequestBody Req<QueryPoolListReqDTO> req) {
        return poolServiceFacade.list(req);
    }

    @ApiOperation(value = "奖池详情", notes = "奖池详情", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<PoolModel> detail(@RequestBody Req<QueryPoolDetailReqDTO> req) {
        return poolServiceFacade.detail(req);
    }

    @ApiOperation(value = "新建奖池", notes = "新建奖池", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp<PoolModel> create(@RequestBody Req<CreatePoolReqDTO> req) {
        return poolServiceFacade.create(req);
    }

    @ApiOperation(value = "更新奖池", notes = "更新奖池", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdatePoolReqDTO> req) {
        return poolServiceFacade.update(req);
    }

    @ApiOperation(value = "删除奖池", notes = "删除奖池", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeletePoolReqDTO> req) {
        return poolServiceFacade.delete(req);
    }

    @ApiOperation(value = "获取当前奖池", notes = "获取当前奖池", httpMethod = "POST")
    @RequestMapping(value = "/getCurrentPool", method = RequestMethod.POST)
    public Resp<PoolModel> getCurrentPool(@RequestBody Req<GetCurrentPoolReqDTO> req){
        return poolServiceFacade.getCurrentPool(req);
    }

    @ApiOperation(value = "获取当前奖池列表", notes = "获取当前奖池列表", httpMethod = "POST")
    @RequestMapping(value = "/getCurrentPools", method = RequestMethod.POST)
    public Resp<List<PoolModel>> getCurrentPools(@RequestBody Req<GetCurrentPoolsReqDTO> req){
        return poolServiceFacade.getCurrentPools(req);
    }

    @ApiOperation(value = "指定奖池提前开奖", notes = "指定奖池提前开奖", httpMethod = "POST")
    @RequestMapping(value = "/runLotteryInAdvance", method = RequestMethod.POST)
    public Resp runLotteryInAdvance(@RequestBody Req<RunLotteryInAdvanceReqDTO> req){
        return poolServiceFacade.runLotteryInAdvance(req);
    }
}
