package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.common.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePoolListener implements Listener<Pool> {
    protected PoolProcessor processor = SpringUtils.getBean(PoolProcessor.class);
}
