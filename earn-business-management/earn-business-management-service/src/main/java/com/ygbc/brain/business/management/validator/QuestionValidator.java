package com.ygbc.brain.business.management.validator;

import com.ygbc.brain.business.common.entity.Pool;
import com.ygbc.brain.business.common.processor.pool.PoolProcessor;
import com.ygbc.brain.business.management.api.dto.question.GetChallengeReqDTO;
import com.ygbc.brain.common.validate.BaseValidator;
import com.ygbc.brain.common.validate.annotation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionValidator extends BaseValidator {

    @Autowired
    private PoolProcessor processor;

    @Validate(value = "poolId")
    public String canChallenge(Long value, GetChallengeReqDTO context){
        Pool pool = processor.getPool(value);
        if(pool.canChallenge()){
            return "当前奖池无法继续挑战";
        }
        return null;
    }
}
