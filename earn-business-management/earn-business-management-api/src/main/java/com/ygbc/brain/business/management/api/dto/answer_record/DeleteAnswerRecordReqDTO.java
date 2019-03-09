package com.ygbc.brain.business.management.api.dto.answer_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class DeleteAnswerRecordReqDTO extends BaseDTO {
    /**
     * 记录排名编号
     */
    private Long answerRecordId;

    public Long getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(Long answerRecordId) {
        this.answerRecordId = answerRecordId;
    }
}
