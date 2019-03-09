package com.ygbc.brain.business.management.api.dto.participant_pool_chart;

import com.ygbc.brain.base.dto.BaseDTO;

public class DeleteParticipantPoolChartReqDTO extends BaseDTO {
    /**
     * 记录排名编号
     */
    private Long participantPoolChartId;

    public Long getParticipantPoolChartId() {
        return participantPoolChartId;
    }

    public void setParticipantPoolChartId(Long participantPoolChartId) {
        this.participantPoolChartId = participantPoolChartId;
    }
}
