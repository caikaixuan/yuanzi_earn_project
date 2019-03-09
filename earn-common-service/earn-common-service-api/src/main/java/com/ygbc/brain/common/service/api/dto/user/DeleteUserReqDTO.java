package com.ygbc.brain.common.service.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class DeleteUserReqDTO extends BaseDTO {

    @NotBlank(message = "请输入登录名称")
    private String loginName;

    public DeleteUserReqDTO() {
    }

    public DeleteUserReqDTO(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
