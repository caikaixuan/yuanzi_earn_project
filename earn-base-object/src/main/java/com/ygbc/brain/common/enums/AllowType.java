package com.ygbc.brain.common.enums;

import com.ygbc.brain.base.enums.BaseIntEnum;

public enum AllowType implements BaseIntEnum {

    ALLOW(1, "允许"),

    NOT_ALLOW(0, "不允许");

    private int value;

    private String desc;

    AllowType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
