package com.ygbc.brain.business.management.api.model;

import com.ygbc.brain.base.model.BaseModel;

public class AnswerRecordModel extends BaseModel {
    /**
    * 记录排名编号
    */
    private Long answerRecordId;

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
     * 回答者答案
     */
    private String answer;

    /** 
    * 参与次数
    */
    private Boolean result;

    public Long getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(Long answerRecordId) {
        this.answerRecordId = answerRecordId;
    }

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