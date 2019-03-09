package com.ygbc.brain.business.management.api.dto.question;

import com.ygbc.brain.base.dto.BaseDTO;

public class GetChallengeReqDTO extends BaseDTO {

    private Long poolId;

    private Long userId;

    private String userNickName;

    private Integer consumeIntegration;

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
        this.userNickName = userNickName;
    }

    public Integer getConsumeIntegration() {
        return consumeIntegration;
    }

    public void setConsumeIntegration(Integer consumeIntegration) {
        this.consumeIntegration = consumeIntegration;
    }
}
