package com.ygbc.brain.authorization.api.dto;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class LoginReqDTO extends BaseDTO {

    @NotBlank(message = "登录名称不能为空")
    private String loginName;

    @NotBlank(message = "登录密码不能为空")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
