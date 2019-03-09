package com.ygbc.brain.common.service.api.dto.role;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class UpdateRoleReqDTO extends BaseDTO {

    @NotBlank(message = "请输入角色名称")
    private String roleName;

    @NotBlank(message = "请输入是否为管理员")
    private Integer isAdmin;

    @NotBlank(message = "请输入角色描述")
    private String roleDesc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
