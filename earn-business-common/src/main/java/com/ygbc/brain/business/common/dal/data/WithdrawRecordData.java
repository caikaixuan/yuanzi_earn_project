package com.ygbc.brain.business.common.dal.data;

import java.math.BigDecimal;

public class WithdrawRecordData extends BaseData {
    /**
    * 充值记录编号
    */
    private Long withdrawRecordId;

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
    private Integer consumeIntegration;

    /** 
    * 充值前积分余额
    */
    private Integer beforeWithdrawIntegration;

    /** 
    * 充值后积分余额
    */
    private Integer afterWithdrawIntegration;

    /** 
    * 状态 S:提现成功 F:提现失败
    */
    private String status;

    public Long getWithdrawRecordId() {
        return withdrawRecordId;
    }

    public void setWithdrawRecordId(Long withdrawRecordId) {
        this.withdrawRecordId = withdrawRecordId;
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

    public Integer getConsumeIntegration() {
        return consumeIntegration;
    }

    public void setConsumeIntegration(Integer consumeIntegration) {
        this.consumeIntegration = consumeIntegration;
    }

    public Integer getBeforeWithdrawIntegration() {
        return beforeWithdrawIntegration;
    }

    public void setBeforeWithdrawIntegration(Integer beforeWithdrawIntegration) {
        this.beforeWithdrawIntegration = beforeWithdrawIntegration;
    }

    public Integer getAfterWithdrawIntegration() {
        return afterWithdrawIntegration;
    }

    public void setAfterWithdrawIntegration(Integer afterWithdrawIntegration) {
        this.afterWithdrawIntegration = afterWithdrawIntegration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}