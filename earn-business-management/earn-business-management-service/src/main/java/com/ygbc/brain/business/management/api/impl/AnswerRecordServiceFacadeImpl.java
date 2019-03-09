package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.management.api.AnswerRecordServiceFacade;
import com.ygbc.brain.business.management.api.dto.answer_record.*;
import com.ygbc.brain.business.management.api.model.AnswerRecordModel;
import com.ygbc.brain.business.management.service.answer_record.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerRecordServiceFacadeImpl implements AnswerRecordServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<AnswerRecordModel>> list(Req<QueryAnswerRecordListReqDTO> req) {
        AnswerRecordListService service = SpringUtils.getBean(AnswerRecordListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<AnswerRecordModel> detail(Req<QueryAnswerRecordDetailReqDTO> req) {
        AnswerRecordDetailService service = SpringUtils.getBean(AnswerRecordDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp create(Req<CreateAnswerRecordReqDTO> req) {
        AnswerRecordCreateService service = SpringUtils.getBean(AnswerRecordCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeleteAnswerRecordReqDTO> req) {
        AnswerRecordDeleteService service = SpringUtils.getBean(AnswerRecordDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdateAnswerRecordReqDTO> req) {
        AnswerRecordUpdateService service = SpringUtils.getBean(AnswerRecordUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
