package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseIntEnum;

public enum QuestionDifficulty implements BaseIntEnum {
    EASY(1,"特等奖"),
    MEDIUM(2,"一等奖"),
    HARD(3,"二等奖");

    private int value;
    private String desc;

    private QuestionDifficulty(int value, String desc){
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
