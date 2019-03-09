package com.ygbc.brain.business.management.api.dto.answer_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryAnswerRecordListReqDTO extends BaseDTO {
    /**
     * 奖池编号
     */
    private Long poolId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private Long questionId;

    /**
     * 参与次数
     */
    private Boolean result;

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
