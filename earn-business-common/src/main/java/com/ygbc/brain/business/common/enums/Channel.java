package com.ygbc.brain.business.common.enums;

import com.ygbc.brain.base.enums.BaseStrEnum;

public enum Channel implements BaseStrEnum {

    ALI_PAYMENT("A","支付宝"),
    WECHAT_PAYMENT("W","微信支付");

    private String value;
    private String desc;

    private Channel(String value, String desc){
        this.desc = desc;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
