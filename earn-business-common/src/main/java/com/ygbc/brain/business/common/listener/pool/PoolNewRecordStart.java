package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.constants.BusinessConstants;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.UserPoolRecord;
import com.ygbc.brain.business.common.enums.PoolProcessorEvent;
import com.ygbc.brain.business.common.enums.PoolStatus;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class PoolNewRecordStart extends BasePoolListener {

    @Override
    public void notify(Pool pool) throws Exception{
        UserPoolRecord userPoolRecord = pool.getObject(BusinessConstants.ATTR_POOL_RECORD);
        if(userPoolRecord != null){
            pool.addUserPoolRecord(userPoolRecord);
            if(pool.getStatus().equals(PoolStatus.CREATED.getValue())){
                pool.setStatus(PoolStatus.ON_GOING.getValue());
            }
            if(pool.getStatus().equals(PoolStatus.LOCKED)){
                processor.notify(pool, PoolProcessorEvent.POOL_BE_LOCKED);
            }
        }
        pool.clearAttrs();
    }
}
