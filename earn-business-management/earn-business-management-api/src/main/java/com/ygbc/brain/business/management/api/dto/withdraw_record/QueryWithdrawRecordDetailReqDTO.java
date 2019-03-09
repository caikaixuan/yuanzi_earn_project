package com.ygbc.brain.business.management.api.dto.withdraw_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryWithdrawRecordDetailReqDTO extends BaseDTO {
    /**
     * 充值记录编号
     */
    private Long withdrawRecordId;

    public Long getWithdrawRecordId() {
        return withdrawRecordId;
    }

    public void setWithdrawRecordId(Long withdrawRecordId) {
        this.withdrawRecordId = withdrawRecordId;
    }
}
