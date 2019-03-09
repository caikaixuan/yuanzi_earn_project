package com.ygbc.brain.authorization.api.dto;

import com.ygbc.brain.base.dto.BaseDTO;

public class LoginRespDTO extends BaseDTO {

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
