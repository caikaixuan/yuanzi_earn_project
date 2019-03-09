package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseStrEnum;

public enum InviteNumberStatus implements BaseStrEnum {
    Frozen("F","冻结"),
    Active("A","活跃");

    private String value;
    private String desc;

    private InviteNumberStatus(String value, String desc){
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
