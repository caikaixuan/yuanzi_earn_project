package com.ygbc.brain.business.management.api.model;

import com.ygbc.brain.base.model.BaseModel;

public class TopicModel extends BaseModel{
    /**
    * 话题编号
    */
    private Long topicId;

    /** 
    * 话题名称
    */
    private String name;

    /** 
    * 话题描述
    */
    private String description;

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}