package com.ygbc.brain.common.model;

import com.ygbc.brain.base.model.BaseModel;

import java.util.List;

public class MenuModel extends BaseModel {

    private String menuName;

    private String url;

    private Long pid;

    private String menuDesc;

    private Integer showOrder;

    private List<MenuModel> childMenuList;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public List<MenuModel> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<MenuModel> childMenuList) {
        this.childMenuList = childMenuList;
    }
}
