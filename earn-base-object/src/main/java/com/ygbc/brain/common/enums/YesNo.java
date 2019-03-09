package com.ygbc.brain.common.enums;

import com.ygbc.brain.base.enums.BaseIntEnum;

public enum YesNo implements BaseIntEnum {

    YES(1, "是"),

    NO(0, "否");

    private int value;

    private String desc;

    YesNo(int value, String desc) {
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

    public byte getByte() {
        return (byte) this.value;
    }
}
