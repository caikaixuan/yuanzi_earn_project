package com.ygbc.brain.business.common.service.base;

import com.ygbc.brain.business.common.context.ServiceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class BaseService {

    /**
     * 日志记录器
     */
    protected Logger logger = null;

    /**
     * 上下文
     */
    protected ServiceContext context = ServiceContext.getInstance();

    public BaseService() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public ServiceContext getContext() {
        return context;
    }
}