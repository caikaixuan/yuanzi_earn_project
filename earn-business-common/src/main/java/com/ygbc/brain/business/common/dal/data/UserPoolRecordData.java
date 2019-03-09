package com.ygbc.brain.business.common.dal.data;

public class UserPoolRecordData extends BaseData {
    /**
    * 挑战记录编号
    */
    private Long userPoolRecordId;

    /** 
    * 用户编号
    */
    private Long userId;

    /** 
    * 奖池编号
    */
    private Long poolId;

    /** 
    * 用户昵称
    */
    private String userNickName;

    /**
     * 花费积分
     */
    private Integer consumeIntegration;

    /** 
    * 答对题数
    */
    private Integer rightNum;

    /**
    * 挑战结果 0：挑战失败；1：挑战成功
    */
    private Boolean result;

    /** 
    * 记录状态
    */
    private String status;

    public Long getUserPoolRecordId() {
        return userPoolRecordId;
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        this.userPoolRecordId = userPoolRecordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    public Integer getConsumeIntegration() {
        return consumeIntegration;
    }

    public void setConsumeIntegration(Integer consumeIntegration) {
        this.consumeIntegration = consumeIntegration;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}