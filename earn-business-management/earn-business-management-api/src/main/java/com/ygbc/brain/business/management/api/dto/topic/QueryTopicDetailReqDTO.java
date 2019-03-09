package com.ygbc.brain.business.management.api.dto.topic;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryTopicDetailReqDTO extends BaseDTO {
    /**
     * 话题编号
     */
    private Long topicId;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
