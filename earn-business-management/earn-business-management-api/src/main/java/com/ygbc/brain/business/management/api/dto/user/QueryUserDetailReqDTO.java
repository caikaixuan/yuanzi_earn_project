package com.ygbc.brain.business.management.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryUserDetailReqDTO extends BaseDTO {
    /**
     * 用户编号
     */
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
