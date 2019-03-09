package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseStrEnum;

public enum UserPoolRecordStatus implements BaseStrEnum {
    INEFFECTIVE("I","无效"),
    EFFECTIVE("E","生效");

    private String value;
    private String desc;

    private UserPoolRecordStatus(String value, String desc){
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
