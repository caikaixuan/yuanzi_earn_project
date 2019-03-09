package com.ygbc.brain.business.common.dal.data;

public class ParticipantPoolChartData extends BaseData {
    /**
    * 记录排名编号
    */
    private Long participantPoolChartId;

    /** 
    * 挑战记录编号
    */
    private Long userPoolRecordId;

    /** 
    * 奖池编号
    */
    private Long poolId;

    /** 
    * 用户编号
    */
    private Long userId;

    /** 
    * 用户昵称
    */
    private String userNickName;

    /** 
    * 参与次数
    */
    private Integer participateTimes;

    /**
     * 成功次数
     */
    private Integer successTimes;

    /** 
    * 收益
    */
    private Integer earnings;

    /** 
    * 排名
    */
    private Integer position;

    /** 
    * 排名状态
    */
    private String status;

    public Long getParticipantPoolChartId() {
        return participantPoolChartId;
    }

    public void setParticipantPoolChartId(Long participantPoolChartId) {
        this.participantPoolChartId = participantPoolChartId;
    }

    public Long getUserPoolRecordId() {
        return userPoolRecordId;
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        this.userPoolRecordId = userPoolRecordId;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    public Integer getParticipateTimes() {
        return participateTimes;
    }

    public void setParticipateTimes(Integer participateTimes) {
        this.participateTimes = participateTimes;
    }

    public Integer getSuccessTimes() {
        return successTimes;
    }

    public void setSuccessTimes(Integer successTimes) {
        this.successTimes = successTimes;
    }

    public Integer getEarnings() {
        return earnings;
    }

    public void setEarnings(Integer earnings) {
        this.earnings = earnings;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}