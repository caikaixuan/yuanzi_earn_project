package com.ygbc.brain.business.management.api.model;


import com.ygbc.brain.base.model.BaseModel;

public class PoolRecordChartModel extends BaseModel {
    /**
    * 挑战成功排名编号
    */
    private Long poolRecordChartId;

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
    * 答对题数
    */
    private Integer rightNum;

    /** 
    * 得分
    */
    private Integer grade;

    /** 
    * 排名
    */
    private Integer position;

    /** 
    * 奖励等级
    */
    private Integer awardLevel;

    /** 
    * 奖励积分
    */
    private Integer awardIntegration;

    /** 
    * 排名状态
    */
    private String status;

    public Long getPoolRecordChartId() {
        return poolRecordChartId;
    }

    public void setPoolRecordChartId(Long poolRecordChartId) {
        this.poolRecordChartId = poolRecordChartId;
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

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(Integer awardLevel) {
        this.awardLevel = awardLevel;
    }

    public Integer getAwardIntegration() {
        return awardIntegration;
    }

    public void setAwardIntegration(Integer awardIntegration) {
        this.awardIntegration = awardIntegration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}