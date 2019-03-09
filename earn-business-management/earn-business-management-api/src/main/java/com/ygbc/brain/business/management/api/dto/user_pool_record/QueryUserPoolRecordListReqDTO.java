package com.ygbc.brain.business.management.api.dto.user_pool_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryUserPoolRecordListReqDTO extends BaseDTO {
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 奖池编号
     */
    private Long poolId;

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
        this.status = status;
    }
}
