package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseIntEnum;

public enum AwardLevel implements BaseIntEnum {
    SPECIAL(1,"特等奖"),
    FIRST_PRIZE(2,"一等奖"),
    SECOND_PRIZE(3,"二等奖"),
    THIRD_PRIZE(4,"三等奖"),
    FORTH_PRIZE(5,"四等奖"),
    FIFTH_PRIZE(6,"五等奖");

    private int value;
    private String desc;

    private AwardLevel(int value, String desc){
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
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
