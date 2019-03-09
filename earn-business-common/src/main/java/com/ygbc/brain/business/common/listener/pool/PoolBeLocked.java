package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.PoolRecordCharts;
import com.ygbc.brain.business.common.enums.PoolStatus;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolBeLocked extends BasePoolListener {

    private static Logger logger = LoggerFactory.getLogger(PoolBeLocked.class);

    @Override
    public void notify(Pool pool) throws Exception{
        if(pool.getStatus().equals(PoolStatus.LOCKED.getValue())){
            logger.debug("------------ 开奖 ------------");
            pool.runLottery();
            // 推送成功挑战记录排行榜
            pool.clearAttrs();
        }
    }
}