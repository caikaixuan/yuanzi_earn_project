package com.ygbc.brain.business.management.api.dto.user_pool_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class DeleteUserPoolRecordReqDTO extends BaseDTO {
    /**
     * 挑战记录编号
     */
    private Long userPoolRecordId;

    public Long getUserPoolRecordId() {
        return userPoolRecordId;
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        this.userPoolRecordId = userPoolRecordId;
    }
}
