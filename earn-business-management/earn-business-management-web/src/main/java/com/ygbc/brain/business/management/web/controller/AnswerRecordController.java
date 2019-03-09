package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.AnswerRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.answer_record.*;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("answerRecord")
@Api(value = "/answerRecord", tags = "", description = "答题记录管理")
public class AnswerRecordController {
    @Autowired
    private AnswerRecordServiceFacade answerRecordServiceFacade;

    @ApiOperation(value = "获取答题记录列表", notes = "获取答题记录列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<AnswerRecordModel>> list(@RequestBody Req<QueryAnswerRecordListReqDTO> req) {
        return answerRecordServiceFacade.list(req);
    }

    @ApiOperation(value = "获取答题记录列表", notes = "获取答题记录列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<AnswerRecordModel> detail(@RequestBody Req<QueryAnswerRecordDetailReqDTO> req) {
        return answerRecordServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取答题记录列表", notes = "获取答题记录列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateAnswerRecordReqDTO> req) {
        return answerRecordServiceFacade.create(req);
    }

    @ApiOperation(value = "获取答题记录列表", notes = "获取答题记录列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateAnswerRecordReqDTO> req) {
        return answerRecordServiceFacade.update(req);
    }

    @ApiOperation(value = "获取答题记录列表", notes = "获取答题记录列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteAnswerRecordReqDTO> req) {
        return answerRecordServiceFacade.delete(req);
    }
}
