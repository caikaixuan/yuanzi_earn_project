package com.ygbc.brain.business.management.api.dto.question;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryQuestionDetailReqDTO extends BaseDTO {
    /**
     * 题目编号
     */
    private Long questionId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
