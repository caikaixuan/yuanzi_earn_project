package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.TopicServiceFacade;
import com.ygbc.brain.business.management.api.dto.topic.*;
import com.ygbc.brain.business.management.api.model.TopicModel;
import com.ygbc.brain.business.management.service.topic.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceFacadeImpl implements TopicServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<TopicModel>> list(Req<QueryTopicListReqDTO> req) {
        TopicListService service = SpringUtils.getBean(TopicListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<TopicModel> detail(Req<QueryTopicDetailReqDTO> req) {
        TopicDetailService service = SpringUtils.getBean(TopicDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateTopicReqDTO> req) {
        TopicCreateService service = SpringUtils.getBean(TopicCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteTopicReqDTO> req) {
        TopicDeleteService service = SpringUtils.getBean(TopicDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateTopicReqDTO> req) {
        TopicUpdateService service = SpringUtils.getBean(TopicUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
