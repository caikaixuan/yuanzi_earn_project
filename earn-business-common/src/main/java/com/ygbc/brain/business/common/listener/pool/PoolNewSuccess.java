package com.ygbc.brain.business.common.listener.pool;

import com.ygbc.brain.business.common.constants.BusinessConstants;
import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.business.common.dal.data.PoolRecordChartData;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.business.common.entity.ParticipantPoolChart;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.PoolRecordChart;
import com.ygbc.brain.business.common.entity.UserPoolRecord;
import com.ygbc.brain.business.common.enums.ParticipantPoolChartStatus;
import com.ygbc.brain.business.common.enums.PoolRecordChartStatus;
import com.ygbc.brain.common.utils.DeepBeanUtils;
import com.ygbc.brain.common.utils.IdWorker;
import java.util.Date;

public class PoolNewSuccess extends BasePoolListener {
    @Override
    public void notify(Pool pool) throws Exception{
        UserPoolRecord userPoolRecord = pool.getObject(BusinessConstants.ATTR_USER_POOL_RECORD);
        pool.addPoolRecordChart(createPoolRecordChart(userPoolRecord));
        pool.addParticipantPoolChart(createParticipantPoolChart(userPoolRecord));
        pool.clearAttrs();
    }

    public PoolRecordChart createPoolRecordChart(UserPoolRecord userPoolRecord) throws Exception {
        UserPoolRecordData userPoolRecordData = userPoolRecord.getData();
        PoolRecordChartData poolRecordChartData = DeepBeanUtils.copyAs(userPoolRecordData,PoolRecordChartData.class);
        long poolRecordChartId = IdWorker.getFlowIdWorkerInstance().nextId();
        poolRecordChartData.setPoolRecordChartId(poolRecordChartId);
        poolRecordChartData.setCreateTime(new Date());
        poolRecordChartData.setStatus(PoolRecordChartStatus.INEFFECTIVE.getValue());
        poolRecordChartData.setId(null);
        return new PoolRecordChart(poolRecordChartData);
    }

    public ParticipantPoolChart createParticipantPoolChart(UserPoolRecord userPoolRecord) throws Exception{
        UserPoolRecordData userPoolRecordData = userPoolRecord.getData();
        ParticipantPoolChartData participantPoolChartData = DeepBeanUtils.copyAs(userPoolRecordData,
                ParticipantPoolChartData.class);
        long ParticipantPoolChartId = IdWorker.getFlowIdWorkerInstance().nextId();
        participantPoolChartData.setParticipantPoolChartId(ParticipantPoolChartId);
        participantPoolChartData.setCreateTime(new Date());
        participantPoolChartData.setStatus(ParticipantPoolChartStatus.INEFFECTIVE.getValue());
        participantPoolChartData.setId(null);
        return new ParticipantPoolChart(participantPoolChartData);
    }
}
