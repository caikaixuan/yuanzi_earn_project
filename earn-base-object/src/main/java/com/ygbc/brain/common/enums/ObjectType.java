package com.ygbc.brain.common.enums;

import com.ygbc.brain.base.enums.BaseStrEnum;

public enum ObjectType implements BaseStrEnum {

    IMPORT_LETTER_OF_CREDIT("lid", "进口信用证"),
    EXPORT_LETTER_OF_CREDIT("led", "出口信用证"),
    DOMESTIC_BUYER_LETTER_OF_CREDIT("did", "国内买方信用证"),
    DOMESTIC_BUYER_DOCUMENT("bdd", "国内买方信用证单据"),
    DOMESTIC_SELLER_LETTER_OF_CREDIT("ded", "国内卖方信用证"),
    DOMESTIC_SELLER_DOCUMENT("bmd", "国内卖方信用证单据"),
    DOMESTIC_SELF_FORFEITING("fpd", "福费廷自营"),
    DOMESTIC_SECONDARY_FORFEITING("ffd", "福费廷转卖/代理"),
    DOMESTIC_ASSET("ass", "国内信用证资产");

    private String value;

    private String desc;

    ObjectType(String value, String desc) {
        this.value = value;
        this.desc = desc;
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
