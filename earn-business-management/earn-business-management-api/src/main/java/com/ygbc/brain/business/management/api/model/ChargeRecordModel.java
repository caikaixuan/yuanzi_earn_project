package com.ygbc.brain.business.management.api.model;

import com.ygbc.brain.base.model.BaseModel;

import java.math.BigDecimal;

public class ChargeRecordModel extends BaseModel {
    /**
    * 充值记录编号
    */
    private Long chargeRecordId;

    /** 
    * 用户编号
    */
    private Long userId;

    /** 
    * 充值金额
    */
    private BigDecimal balance;

    /** 
    * 充值渠道 A:支付宝；W:微信支付
    */
    private String channel;

    /** 
    * 获取积分数量
    */
    private Integer getIntegration;

    /** 
    * 充值前积分余额
    */
    private Integer beforeChargeIntegration;

    /** 
    * 充值后积分余额
    */
    private Integer afterChargeIntegration;

    /** 
    * 状态 S:支付成功 F:支付失败
    */
    private String status;

    public Long getChargeRecordId() {
        return chargeRecordId;
    }

    public void setChargeRecordId(Long chargeRecordId) {
        this.chargeRecordId = chargeRecordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Integer getGetIntegration() {
        return getIntegration;
    }

    public void setGetIntegration(Integer getIntegration) {
        this.getIntegration = getIntegration;
    }

    public Integer getBeforeChargeIntegration() {
        return beforeChargeIntegration;
    }

    public void setBeforeChargeIntegration(Integer beforeChargeIntegration) {
        this.beforeChargeIntegration = beforeChargeIntegration;
    }

    public Integer getAfterChargeIntegration() {
        return afterChargeIntegration;
    }

    public void setAfterChargeIntegration(Integer afterChargeIntegration) {
        this.afterChargeIntegration = afterChargeIntegration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}