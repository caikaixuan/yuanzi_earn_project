package com.ygbc.brain.business.management.api.impl;

import com.ygbc.brain.base.rpc.Req;
import com.ygbc.brain.base.rpc.Resp;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.management.api.PoolServiceFacade;
import com.ygbc.brain.business.management.api.dto.pool.*;
import com.ygbc.brain.business.management.api.model.PoolModel;
import com.ygbc.brain.business.management.service.pool.*;
import com.ygbc.brain.common.exception.ExceptionHandler;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PoolServiceFacadeImpl implements PoolServiceFacade {
    @Autowired
    private ExceptionHandler exceptionHandler;

    @Override
    public Resp<List<PoolModel>> list(Req<QueryPoolListReqDTO> req) {
        PoolListService service = SpringUtils.getBean(PoolListService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<PoolModel> detail(Req<QueryPoolDetailReqDTO> req) {
        PoolDetailService service = SpringUtils.getBean(PoolDetailService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<PoolModel> create(Req<CreatePoolReqDTO> req) {
        PoolCreateService service = SpringUtils.getBean(PoolCreateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp delete(Req<DeletePoolReqDTO> req) {
        PoolDeleteService service = SpringUtils.getBean(PoolDeleteService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp update(Req<UpdatePoolReqDTO> req) {
        PoolUpdateService service = SpringUtils.getBean(PoolUpdateService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<PoolModel> getCurrentPool(Req<GetCurrentPoolReqDTO> req) {
        GetCurrentPoolService service = SpringUtils.getBean(GetCurrentPoolService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp<List<PoolModel>> getCurrentPools(Req<GetCurrentPoolsReqDTO> req) {
        GetCurrentPoolsService service = SpringUtils.getBean(GetCurrentPoolsService.class);
        try {
            return service.execute(req);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }

    @Override
    public Resp runLotteryInAdvance(Req<RunLotteryInAdvanceReqDTO> req) {
        return null;
    }
}
