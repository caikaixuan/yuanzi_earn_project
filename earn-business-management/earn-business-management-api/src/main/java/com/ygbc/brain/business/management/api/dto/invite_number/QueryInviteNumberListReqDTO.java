package com.ygbc.brain.business.management.api.dto.invite_number;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryInviteNumberListReqDTO extends BaseDTO {
    /**
     * 状态 F:冻结禁用；A:活跃
     */
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
