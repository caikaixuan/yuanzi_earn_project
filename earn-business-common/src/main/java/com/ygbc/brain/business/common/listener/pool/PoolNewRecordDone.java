package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.constants.BusinessConstants;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.business.common.dal.data.PoolRecordChartData;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.business.common.entity.ParticipantPoolChart;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.PoolRecordChart;
import com.ygbc.brain.business.common.entity.UserPoolRecord;
import com.ygbc.brain.business.common.enums.*;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;

import java.util.Date;

public class PoolNewRecordDone extends BasePoolListener {

    @Override
    public void notify(Pool pool) throws Exception{
        /**
         * 判断该条记录是否挑战成功，若成功则增加一条chart_record
         */
        UserPoolRecord userPoolRecord = pool.getObject(BusinessConstants.ATTR_USER_POOL_RECORD);
        if(userPoolRecord.getResult()){
            processor.notify(pool,PoolProcessorEvent.POOL_NEW_SUCCESS);
            pool.clearAttrs();
        }
        if(pool.getStatus().equals(PoolStatus.LOCKED.getValue())){
            processor.notify(pool, PoolProcessorEvent.POOL_BE_LOCKED);
        }
        // push message -- userPoolRecord
        // sort poolRecordChart
        pool.clearAttrs();
    }


}
