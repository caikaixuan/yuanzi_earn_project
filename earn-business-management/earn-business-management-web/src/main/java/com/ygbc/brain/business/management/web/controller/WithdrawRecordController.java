package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.WithdrawRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.withdraw_record.*;
import com.ygbc.brain.business.management.api.model.WithdrawRecordModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("withdrawRecord")
@Api(value = "/withdrawRecord", tags = "", description = "提现记录管理")
public class WithdrawRecordController {
    @Autowired
    private WithdrawRecordServiceFacade withdrawRecordServiceFacade;

    @ApiOperation(value = "获取提现记录列表", notes = "获取提现记录列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<WithdrawRecordModel>> list(@RequestBody Req<QueryWithdrawRecordListReqDTO> req) {
        return withdrawRecordServiceFacade.list(req);
    }

    @ApiOperation(value = "获取提现记录列表", notes = "获取提现记录列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<WithdrawRecordModel> detail(@RequestBody Req<QueryWithdrawRecordDetailReqDTO> req) {
        return withdrawRecordServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取提现记录列表", notes = "获取提现记录列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateWithdrawRecordReqDTO> req) {
        return withdrawRecordServiceFacade.create(req);
    }

    @ApiOperation(value = "获取提现记录列表", notes = "获取提现记录列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateWithdrawRecordReqDTO> req) {
        return withdrawRecordServiceFacade.update(req);
    }

    @ApiOperation(value = "获取提现记录列表", notes = "获取提现记录列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteWithdrawRecordReqDTO> req) {
        return withdrawRecordServiceFacade.delete(req);
    }
}
