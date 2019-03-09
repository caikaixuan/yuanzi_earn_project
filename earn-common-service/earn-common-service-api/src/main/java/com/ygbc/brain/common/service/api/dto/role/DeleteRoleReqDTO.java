package com.ygbc.brain.common.service.api.dto.role;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class DeleteRoleReqDTO extends BaseDTO {

    @NotBlank(message = "请输入角色名称")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
