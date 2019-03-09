package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.QuestionServiceFacade;
import com.ygbc.brain.business.management.api.dto.question.*;
import com.ygbc.brain.business.management.api.model.QuestionModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
@Api(value = "/question", tags = "", description = "问题管理")
public class QuestionController {
    @Autowired
    private QuestionServiceFacade questionServiceFacade;

    @ApiOperation(value = "获取问题列表", notes = "获取问题列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<QuestionModel>> list(@RequestBody Req<QueryQuestionListReqDTO> req) {
        return questionServiceFacade.list(req);
    }

    @ApiOperation(value = "问题详情", notes = "问题详情", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<QuestionModel> detail(@RequestBody Req<QueryQuestionDetailReqDTO> req) {
        return questionServiceFacade.detail(req);
    }

    @ApiOperation(value = "新建问题", notes = "新建问题", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateQuestionReqDTO> req) {
        return questionServiceFacade.create(req);
    }

    @ApiOperation(value = "更新问题", notes = "更新问题", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateQuestionReqDTO> req) {
        return questionServiceFacade.update(req);
    }

    @ApiOperation(value = "删除问题", notes = "删除问题", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteQuestionReqDTO> req) {
        return questionServiceFacade.delete(req);
    }

    @ApiOperation(value = "获取挑战内容", notes = "获取挑战内容", httpMethod = "POST")
    @RequestMapping(value = "/getChallenge", method = RequestMethod.POST)
    public Resp getChallenge(@RequestBody Req<GetChallengeReqDTO> req) {
        return questionServiceFacade.getChallenge(req);
    }

}
