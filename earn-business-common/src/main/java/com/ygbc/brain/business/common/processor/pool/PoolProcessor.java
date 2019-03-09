package com.ygbc.brain.business.common.processor.pool;

import com.ygbc.brain.business.common.dal.dao.PoolDao;
import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.common.dal.data.SysParameterData;
import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.PoolRecordCharts;
import com.ygbc.brain.business.common.entity.SysParameter;
import com.ygbc.brain.business.common.enums.PoolProcessorEvent;
import com.ygbc.brain.business.common.enums.PoolStatus;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.listener.Listeners;
import com.ygbc.brain.business.common.listener.Observable;
import com.ygbc.brain.business.common.listener.pool.*;
import com.ygbc.brain.business.common.module.Platform;
import com.ygbc.brain.common.enums.TrueFalse;
import com.ygbc.brain.common.utils.IdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class PoolProcessor implements Observable<Pool, PoolProcessorEvent> {

    private static Logger logger = LoggerFactory.getLogger(PoolProcessor.class);

    @Autowired
    private PoolDao dao;

    private final Map<Long, Pool> currentPools = new HashMap<>();

    public final Listeners<Pool, PoolProcessorEvent> poolListeners = new Listeners<>();

    private final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

    private final Runnable poolThread = () -> {
        Set<Long> keySet = currentPools.keySet();
        Iterator<Long> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            long poolId = iterator.next();
            Pool pool = currentPools.get(poolId);
            if (pool.getStatus().equals(PoolStatus.LOCKED) || pool.getPlanEndTime().compareTo(new Date()) < 0) {
                try {
                    pool.setStatus(PoolStatus.LOCKED.getValue());
                    PoolProcessor.this.notify(pool, PoolProcessorEvent.POOL_BE_LOCKED);
                    iterator.remove();
                    if(currentPools.size() == 0){
                        beginNewPool();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public PoolProcessor() {

    }

    @PostConstruct
    private void init() {
        init_listeners();
        init_pools();
        init_thread();
    }

    private void init_listeners() {
        logger.debug("PoolProcessor init listeners");
        poolListeners.addListener(new PoolCreate(), PoolProcessorEvent.POOL_CREATE);
        poolListeners.addListener(new PoolStart(), PoolProcessorEvent.POOL_START);
        poolListeners.addListener(new PoolNewRecordStart(), PoolProcessorEvent.POOL_NEW_RECORD_START);
        poolListeners.addListener(new PoolNewParticipant(), PoolProcessorEvent.POOL_NEW_PARTICIPANT);
        poolListeners.addListener(new PoolNewRecordDone(), PoolProcessorEvent.POOL_NEW_RECORD_DONE);
        poolListeners.addListener(new PoolNewSuccess(), PoolProcessorEvent.POOL_NEW_SUCCESS);
        poolListeners.addListener(new PoolBeLocked(), PoolProcessorEvent.POOL_BE_LOCKED);
        poolListeners.addListener(new PoolRunLottery(), PoolProcessorEvent.POOL_RUN_LOTTERY);
        poolListeners.addListener(new PoolDone(), PoolProcessorEvent.POOL_DONE);
    }

    private void init_thread() {
        logger.debug("pool_thread starting ...");
        scheduledThreadPool.scheduleWithFixedDelay(poolThread, 2, 5, TimeUnit.SECONDS);
    }

    private void init_pools() {
        logger.debug("PoolProcessor init pools");
        if (isNeedCreatePool()) {
            if (dao.selectCountToBeDone() > 0) {
                List<PoolData> poolDataList = dao.selectPoolToBeDone();
                for (PoolData poolData : poolDataList) {
                    addPool(new Pool(poolData));
                }
            }else{
                try {
                    beginNewPool();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        logger.debug("current pool's size :" + currentPools.size());
    }

    public Pool getPool() {
        Iterator<Long> iterator = currentPools.keySet().iterator();
        if(iterator.hasNext()){
            return currentPools.get(iterator.next());
        }
        return null;
    }


    public Pool getPool(Long poolId) {
        if (currentPools.containsKey(poolId)) {
            return currentPools.get(poolId);
        } else {
            return null;
        }
    }

    public List<Pool> getPools() {
        List<Pool> pools = new ArrayList<>();
        Set<Long> keys = currentPools.keySet();
        for (Long poolId : keys) {
            pools.add(getPool(poolId));
        }
        return pools;
    }

    public boolean isNeedCreatePool() {
        if (currentPools.size() == 0) {
            return true;
        }
        return false;
    }

    public Pool beginNewPool() throws Exception {
        Pool pool = createPoolBaseOnSysParameter();
        notify(pool, PoolProcessorEvent.POOL_START);
        return addPool(pool);
    }

    public Pool createPoolBaseOnSysParameter() {
        Pool pool = new Pool();
        PoolData poolData = new PoolData();
        SysParameterData sysParameterData = SysParameter.getInstance().getData();
        Date now = new Date();
        Date endTime = new Date(now.getTime() + sysParameterData.getPoolPlanPeriod()  *
                60 * 1000);
        try {
            poolData.setPoolId(IdWorker.getFlowIdWorkerInstance().nextId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        poolData.setInitIntegration(sysParameterData.getPoolInitIntegration());
        poolData.setInitParticipateIntegration(sysParameterData.getPoolInitParticipateIntegration());
        poolData.setIntegrationMax(sysParameterData.getPoolIntegrationMax());
        poolData.setIntegrationMin(sysParameterData.getPoolIntegrationMin());
        poolData.setPlanParticipationRate(sysParameterData.getPoolPlanParticipationRate());
        poolData.setPlanParticipantRate(sysParameterData.getPoolPlanParticipantRate());
        poolData.setCurrentParticipationRate(0);
        poolData.setCurrentParticipantRate(0);
        poolData.setCurrentIntegration(poolData.getInitIntegration());
        poolData.setCurrentParticipateIntegration(poolData.getInitParticipateIntegration());
        poolData.setParticipantNum(0);
        poolData.setParticipationTimes(0);
        poolData.setWinnerNum(0);
        poolData.setSuccessTimes(0);
        poolData.setPlanPeriod(sysParameterData.getPoolPlanPeriod());
        poolData.setCreateTime(now);
        poolData.setPlanEndTime(endTime);
        poolData.setAwardIntegration(0);
        poolData.setProfitIntegration(0);
        poolData.setNeedMeddle(sysParameterData.getPoolNeedMeddle());
        poolData.setIsEarn(TrueFalse.TRUE.getValue());
        poolData.setIsDel(TrueFalse.FALSE.getValue());
        poolData.setStatus(PoolStatus.CREATED.getValue());
        poolData.setVer(sysParameterData.getVer());
        Platform.sdbInsert(poolData);
        pool.setData(poolData);
        pool.setPoolRecordCharts(new PoolRecordCharts(pool));
        logger.info("新建一个奖池。编号：" + poolData.getPoolId());
        return pool;
    }


    public void runLottery(Pool pool) {
        pool.runLottery();
    }

    public void runLottery(long poolId) {
        Pool pool = getPool(poolId);
        runLottery(pool);
    }

    public Pool addPool(Pool pool) {
        if (!currentPools.containsKey(pool.getPoolId())) {
            currentPools.put(pool.getPoolId(), pool);
            return pool;
        }
        return null;
    }

    public Pool removePool(Pool pool) {
        if (currentPools.containsKey(pool.getPoolId())) {
            return currentPools.remove(pool.getPoolId());
        }
        return null;
    }

    public void save(Pool pool) {
        pool.save();
    }

    public void notify(Long poolId, PoolProcessorEvent event) throws Exception {
        Pool pool = getPool(poolId);
        if (pool != null) {
            poolListeners.notify(pool, event);
        }
    }

    public void notify(Pool pool, PoolProcessorEvent event) throws Exception {
        notify(pool.getPoolId(), event);
    }

    @Override
    public boolean addListener(Listener<Pool> listener, PoolProcessorEvent eventType) {
        return poolListeners.addListener(listener, eventType);
    }

    @Override
    public boolean removeListener(Listener<Pool> listener, PoolProcessorEvent eventType) {
        return poolListeners.removeListener(listener, eventType);
    }

}
