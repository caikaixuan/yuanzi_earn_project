package com.ygbc.brain.common.service.api.dto.menu;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryMenuListReqDTO extends BaseDTO {

    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
