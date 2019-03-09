package com.ygbc.brain.common.service.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class QueryUserDetailReqDTO extends BaseDTO {

    @NotBlank(message = "登录名称为必输项")
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
