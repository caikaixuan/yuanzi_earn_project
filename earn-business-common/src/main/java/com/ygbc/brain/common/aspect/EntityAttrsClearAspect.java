package com.ygbc.brain.common.aspect;

import com.ygbc.brain.business.common.dal.data.BaseData;
import com.ygbc.brain.business.common.entity.AttributeEntity;
import com.ygbc.brain.business.common.entity.BaseEntity;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class EntityAttrsClearAspect {

    public EntityAttrsClearAspect(){
        System.out.println("EntityAttrsClearAspect is initing ...");
    }

    public void afterReturn(JoinPoint call){
        Object[] args = call.getArgs();
        for(Object arg : args){
            if(arg instanceof BaseEntity){
                ((AttributeEntity) arg).clearAttrs();
            }
        }
    }
}
