package com.ygbc.brain.common.service.api.dto.menu;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class QueryMenuDetailReqDTO extends BaseDTO {

    @NotBlank(message = "请输入菜单名称")
    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
