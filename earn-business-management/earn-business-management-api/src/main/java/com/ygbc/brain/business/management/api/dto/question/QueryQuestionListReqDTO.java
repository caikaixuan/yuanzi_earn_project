package com.ygbc.brain.business.management.api.dto.question;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryQuestionListReqDTO extends BaseDTO {
    /**
     * 话题编号
     */
    private Long topicId;

    /**
     * 题目类型
     */
    private Integer type;

    /**
     * 题目难度值
     */
    private Integer difficulty;

    /**
     * 答对率
     */
    private Integer currentRate;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(Integer currentRate) {
        this.currentRate = currentRate;
    }
}
