package com.ygbc.brain.business.management.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

public class QueryUserListReqDTO extends BaseDTO {
    /**
     * 计划挑战成功概率
     */
    private Integer planRate;

    /**
     * 当前概率
     */
    private Integer currentRate;

    /**
     * 擅长话题编号
     */
    private Long goodAt;

    /**
     * 兴趣话题编号
     */
    private Long interestIn;

    /**
     * 是否有权邀请
     */
    private Boolean canInvite;

    /**
     * 是否受邀而来
     */
    private Boolean isInvited;

    /**
     * 介绍人编号
     */
    private Long invitorUserId;

    /**
     * 是否机器人
     */
    private Boolean isRobot;

    /**
     * 积分余额
     */
    private Integer integration;

    /**
     * 上次提现时间
     */
    private Date lastWithdraw;

    /**
     * 是否有权提现
     */
    private Boolean canWithdraw;

    /**
     * 提现总金额
     */
    private BigDecimal withdraw;

    /**
     * 积分盈利
     */
    private Integer gain;

    /**
     * 上周盈利
     */
    private Integer lastWeekGain;

    /**
     * 充值总金额
     */
    private BigDecimal charge;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 状态 F:冻结;A:活跃;C:不活跃
     */
    private String status;

    public Integer getPlanRate() {
        return planRate;
    }

    public void setPlanRate(Integer planRate) {
        this.planRate = planRate;
    }

    public Integer getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Integer currentRate) {
        this.currentRate = currentRate;
    }

    public Long getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(Long goodAt) {
        this.goodAt = goodAt;
    }

    public Long getInterestIn() {
        return interestIn;
    }

    public void setInterestIn(Long interestIn) {
        this.interestIn = interestIn;
    }

    public Boolean getCanInvite() {
        return canInvite;
    }

    public void setCanInvite(Boolean canInvite) {
        this.canInvite = canInvite;
    }

    public Boolean getInvited() {
        return isInvited;
    }

    public void setInvited(Boolean invited) {
        isInvited = invited;
    }

    public Long getInvitorUserId() {
        return invitorUserId;
    }

    public void setInvitorUserId(Long invitorUserId) {
        this.invitorUserId = invitorUserId;
    }

    public Boolean getRobot() {
        return isRobot;
    }

    public void setRobot(Boolean robot) {
        isRobot = robot;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Date getLastWithdraw() {
        return lastWithdraw;
    }

    public void setLastWithdraw(Date lastWithdraw) {
        this.lastWithdraw = lastWithdraw;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }

    public Integer getLastWeekGain() {
        return lastWeekGain;
    }

    public void setLastWeekGain(Integer lastWeekGain) {
        this.lastWeekGain = lastWeekGain;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
