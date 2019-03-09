package com.ygbc.brain.business.management.api.dto.invite_number;

import com.ygbc.brain.base.dto.BaseDTO;

public class DeleteInviteNumberReqDTO extends BaseDTO {
    /**
     * 邀请码编号
     */
    private Long inviteNumberId;

    public Long getInviteNumberId() {
        return inviteNumberId;
    }

    public void setInviteNumberId(Long inviteNumberId) {
        this.inviteNumberId = inviteNumberId;
    }
}
