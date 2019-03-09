package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.listener.Listener;

public class PoolCreate extends BasePoolListener {
    @Override
    public void notify(Pool pool)throws Exception {
        pool.clearAttrs();
    }
}
