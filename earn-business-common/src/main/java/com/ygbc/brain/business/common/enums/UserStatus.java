package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseStrEnum;

public enum UserStatus implements BaseStrEnum {
    FROZEN_USER("F","冻结用户"),
    ACTIVE_USER("A","活跃用户"),
    COLD_USER("C","非活跃用户"),
    NEW_USER("N","新用户");

    private String value;
    private String desc;

    private UserStatus(String value, String desc){
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
