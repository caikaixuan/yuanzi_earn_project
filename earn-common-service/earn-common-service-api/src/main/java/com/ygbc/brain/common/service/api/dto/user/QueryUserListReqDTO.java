package com.ygbc.brain.common.service.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryUserListReqDTO extends BaseDTO {

    private String loginName;

    private String userName;

    private Integer status;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
