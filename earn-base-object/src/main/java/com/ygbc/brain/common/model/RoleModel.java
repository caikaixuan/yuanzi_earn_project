package com.ygbc.brain.common.model;

import com.ygbc.brain.base.model.BaseModel;

public class RoleModel extends BaseModel {

    private String roleName;

    private String roleDesc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
