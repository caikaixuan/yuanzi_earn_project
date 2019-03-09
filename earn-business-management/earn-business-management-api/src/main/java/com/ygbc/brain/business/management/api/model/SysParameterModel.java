package com.ygbc.brain.business.management.api.model;

import com.ygbc.brain.base.model.BaseModel;

public class SysParameterModel extends BaseModel{
    /**
     * 充值汇率
     */
    private Integer chargeExchangeRate;

    /**
     * 提现汇率
     */
    private Integer withdrawExchangeRate;

    /**
     * 初始奖励积分（成本）
     */
    private Integer poolInitIntegration;

    /**
     * 初始参与所需积分
     */
    private Integer poolInitParticipateIntegration;

    /**
     * 奖池计划参与成功率
     */
    private Integer poolPlanParticipationRate;

    /**
     * 奖池计划参与者成功率
     */
    private Integer poolPlanParticipantRate;

    /**
     * 奖池累积的积分上限
     */
    private Integer poolIntegrationMax;

    /**
     * 奖池累积的积分下限
     */
    private Integer poolIntegrationMin;

    /**
     * 是否干预
     */
    private Boolean poolNeedMeddle;

    /**
     * 奖池持续时间
     */
    private Integer poolPlanPeriod;
    /**
     * 用户挑战成功率
     */
    private Integer userPlanRate;

    /**
     * 是否开通邀请功能
     */
    private Boolean userCanInvite;

    /**
     * 总用户人数限制
     */
    private Integer userNumLimit;

    /**
     * 成功及格线
     */
    private Integer successLine;

    /**
     * 邀请人数限制
     */
    private Integer inviteFriendNumLimit;

    /**
     * 系统版本号
     */
    private Integer appVersion;

    public Integer getChargeExchangeRate() {
        return chargeExchangeRate;
    }

    public void setChargeExchangeRate(Integer chargeExchangeRate) {
        this.chargeExchangeRate = chargeExchangeRate;
    }

    public Integer getWithdrawExchangeRate() {
        return withdrawExchangeRate;
    }

    public void setWithdrawExchangeRate(Integer withdrawExchangeRate) {
        this.withdrawExchangeRate = withdrawExchangeRate;
    }

    public Integer getPoolInitIntegration() {
        return poolInitIntegration;
    }

    public void setPoolInitIntegration(Integer poolInitIntegration) {
        this.poolInitIntegration = poolInitIntegration;
    }

    public Integer getPoolInitParticipateIntegration() {
        return poolInitParticipateIntegration;
    }

    public void setPoolInitParticipateIntegration(Integer poolInitParticipateIntegration) {
        this.poolInitParticipateIntegration = poolInitParticipateIntegration;
    }

    public Integer getPoolPlanParticipationRate() {
        return poolPlanParticipationRate;
    }

    public void setPoolPlanParticipationRate(Integer poolPlanParticipationRate) {
        this.poolPlanParticipationRate = poolPlanParticipationRate;
    }

    public Integer getPoolPlanParticipantRate() {
        return poolPlanParticipantRate;
    }

    public void setPoolPlanParticipantRate(Integer poolPlanParticipantRate) {
        this.poolPlanParticipantRate = poolPlanParticipantRate;
    }

    public Integer getPoolIntegrationMax() {
        return poolIntegrationMax;
    }

    public void setPoolIntegrationMax(Integer poolIntegrationMax) {
        this.poolIntegrationMax = poolIntegrationMax;
    }

    public Integer getPoolIntegrationMin() {
        return poolIntegrationMin;
    }

    public void setPoolIntegrationMin(Integer poolIntegrationMin) {
        this.poolIntegrationMin = poolIntegrationMin;
    }

    public Boolean getPoolNeedMeddle() {
        return poolNeedMeddle;
    }

    public void setPoolNeedMeddle(Boolean poolNeedMeddle) {
        this.poolNeedMeddle = poolNeedMeddle;
    }

    public Integer getPoolPlanPeriod() {
        return poolPlanPeriod;
    }

    public void setPoolPlanPeriod(Integer poolPlanPeriod) {
        this.poolPlanPeriod = poolPlanPeriod;
    }

    public Integer getUserPlanRate() {
        return userPlanRate;
    }

    public void setUserPlanRate(Integer userPlanRate) {
        this.userPlanRate = userPlanRate;
    }

    public Boolean getUserCanInvite() {
        return userCanInvite;
    }

    public void setUserCanInvite(Boolean userCanInvite) {
        this.userCanInvite = userCanInvite;
    }

    public Integer getUserNumLimit() {
        return userNumLimit;
    }

    public Integer getSuccessLine() {
        return successLine;
    }

    public void setSuccessLine(Integer successLine) {
        this.successLine = successLine;
    }

    public void setUserNumLimit(Integer userNumLimit) {
        this.userNumLimit = userNumLimit;
    }

    public Integer getInviteFriendNumLimit() {
        return inviteFriendNumLimit;
    }

    public void setInviteFriendNumLimit(Integer inviteFriendNumLimit) {
        this.inviteFriendNumLimit = inviteFriendNumLimit;
    }

    public Integer getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Integer appVersion) {
        this.appVersion = appVersion;
    }

}