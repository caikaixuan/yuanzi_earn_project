package com.ygbc.brain.business.management.api.dto.topic;

import com.ygbc.brain.base.dto.BaseDTO;

public class CreateTopicReqDTO extends BaseDTO {
    /**
     * 话题名称
     */
    private String name;

    /**
     * 话题描述
     */
    private String description;

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
