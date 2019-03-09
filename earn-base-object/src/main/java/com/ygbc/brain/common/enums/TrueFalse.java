package com.ygbc.brain.common.enums;

import com.ygbc.brain.base.enums.BaseBooleanEnum;

public enum TrueFalse implements BaseBooleanEnum {

    TRUE(true, "真"),

    FALSE(false, "假");

    private boolean value;

    private String desc;

    TrueFalse(boolean value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
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
