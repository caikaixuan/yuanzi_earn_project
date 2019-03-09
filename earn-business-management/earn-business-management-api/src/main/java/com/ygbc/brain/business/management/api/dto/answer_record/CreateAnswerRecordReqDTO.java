package com.ygbc.brain.business.management.api.dto.answer_record;

import com.ygbc.brain.base.dto.BaseDTO;

public class CreateAnswerRecordReqDTO extends BaseDTO {
    /**
     * 挑战记录编号
     */
    private Long userPoolRecordId;

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
     * 挑战者答案
     */
    private String answer;

    /**
     * 回答结果
     */
    private Boolean result;

    public Long getUserPoolRecordId() {
        return userPoolRecordId;
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        this.userPoolRecordId = userPoolRecordId;
    }

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
