package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseIntEnum;

public enum QuestionType implements BaseIntEnum {
    CHOICE(1,"选择题"),
    JUDGE(2,"判断题"),
    ESSAY(3,"问答题"),
    FILL(4,"填空题");

    private int value;
    private String desc;

    private QuestionType(int value, String desc){
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
