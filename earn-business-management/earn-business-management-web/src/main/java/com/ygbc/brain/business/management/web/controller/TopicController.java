package com.ygbc.brain.business.management.web.controller;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.TopicServiceFacade;
import com.ygbc.brain.business.management.api.dto.topic.*;
import com.ygbc.brain.business.management.api.model.TopicModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("topic")
@Api(value = "/topic", tags = "", description = "话题管理")
public class TopicController {
    @Autowired
    private TopicServiceFacade topicServiceFacade;

    @ApiOperation(value = "获取话题列表", notes = "获取话题列表", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Resp<List<TopicModel>> list(@RequestBody Req<QueryTopicListReqDTO> req) {
        return topicServiceFacade.list(req);
    }

    @ApiOperation(value = "获取话题列表", notes = "获取话题列表", httpMethod = "POST")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Resp<TopicModel> detail(@RequestBody Req<QueryTopicDetailReqDTO> req) {
        return topicServiceFacade.detail(req);
    }

    @ApiOperation(value = "获取话题列表", notes = "获取话题列表", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Resp create(@RequestBody Req<CreateTopicReqDTO> req) {
        return topicServiceFacade.create(req);
    }

    @ApiOperation(value = "获取话题列表", notes = "获取话题列表", httpMethod = "POST")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Resp update(@RequestBody Req<UpdateTopicReqDTO> req) {
        return topicServiceFacade.update(req);
    }

    @ApiOperation(value = "获取话题列表", notes = "获取话题列表", httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Resp delete(@RequestBody Req<DeleteTopicReqDTO> req) {
        return topicServiceFacade.delete(req);
    }
}
