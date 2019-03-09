package com.ygbc.brain.business.management.api.dto.pool;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryPoolDetailReqDTO extends BaseDTO {
    /**
     * 奖池id
     */
    private Long poolId;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }
}
