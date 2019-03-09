package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseStrEnum;

public enum PoolStatus implements BaseStrEnum {
    CREATED("C","新建待首位用户"),
    ON_GOING("O","进行中"),
    LOCKED("L","锁定"),
    DONE("D","完成");

    private String value;
    private String desc;

    private PoolStatus(String value, String desc){
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
