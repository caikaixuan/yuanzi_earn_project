package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;

public class PoolDone extends BasePoolListener {

    @Override
    public void notify(Pool pool) throws Exception{
        pool.save();
        //推送奖池结束的消息
        Pool newPool = processor.beginNewPool();
        //推送新奖池的消息
        pool.clearAttrs();
    }
}
