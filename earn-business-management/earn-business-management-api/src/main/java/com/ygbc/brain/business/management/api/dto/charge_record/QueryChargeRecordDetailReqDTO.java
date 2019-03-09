package com.ygbc.brain.business.management.api.dto.charge_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryChargeRecordDetailReqDTO extends BaseDTO {
    /**
     * 充值记录编号
     */
    private Long chargeRecordId;

    public Long getChargeRecordId() {
        return chargeRecordId;
    }

    public void setChargeRecordId(Long chargeRecordId) {
        this.chargeRecordId = chargeRecordId;
    }
}
