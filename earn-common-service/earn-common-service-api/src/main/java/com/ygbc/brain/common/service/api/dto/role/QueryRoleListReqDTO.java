package com.ygbc.brain.common.service.api.dto.role;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryRoleListReqDTO extends BaseDTO {

    private String roleName;

    private Integer isAdmin;

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

}
