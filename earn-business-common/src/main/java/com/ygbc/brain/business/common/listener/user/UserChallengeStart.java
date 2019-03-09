package com.ygbc.brain.business.common.listener.user;

import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.entity.User;
import com.ygbc.brain.business.common.listener.Listener;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class UserChallengeStart implements Listener<User> {
    @Autowired
    private PoolProcessor processor;
    @Override
    public void notify(User user) {
        Long poolId = user.getLong("poolId");
        Pool pool = processor.getPool(poolId);
        user.setIntegration(user.getIntegration() - pool.getCurrentParticipateIntegration());
        user.setChallengeNum(user.getChallengeNum() + 1);
    }
}
