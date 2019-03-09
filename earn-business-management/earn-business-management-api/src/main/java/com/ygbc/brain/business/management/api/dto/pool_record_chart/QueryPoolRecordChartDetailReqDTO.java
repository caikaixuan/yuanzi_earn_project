package com.ygbc.brain.business.management.api.dto.pool_record_chart;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryPoolRecordChartDetailReqDTO extends BaseDTO {
    /**
     * 挑战成功排名编号
     */
    private Long poolRecordChartId;

    public Long getPoolRecordChartId() {
        return poolRecordChartId;
    }

    public void setPoolRecordChartId(Long poolRecordChartId) {
        this.poolRecordChartId = poolRecordChartId;
    }
}
