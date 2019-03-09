package com.ygbc.brain.business.common.entity;


import com.ygbc.brain.business.common.dal.data.BaseData;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseEntity<T extends BaseData> implements Serializable{
    private static final long serialVersionUID = 2952262724582794319L;

    protected T data;

    public BaseEntity(){

    }

    public BaseEntity(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getId() {
        return this.data.getId();
    }

    public void setId(Long id) {
        this.data.setId(id);
    }

    public Date getCreateTime() {
        return this.data.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.data.setCreateTime(createTime);
    }

    public String getCreateBy() {
        return this.data.getCreateBy();
    }

    public void setCreateBy(String createBy) {
        this.data.setCreateBy(createBy);
    }

    public Date getUpdateTime() {
        return this.data.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.data.setUpdateTime(updateTime);
    }

    public String getUpdateBy() {
        return this.data.getUpdateBy();
    }

    public void setUpdateBy(String updateBy) {
        this.data.setUpdateBy(updateBy);
    }

    public int getVer() {
        return this.data.getVer();
    }

    public void setVer(int ver) {
        this.data.setVer(ver);
    }

    public Boolean getIsDel() {
        return this.data.getIsDel();
    }

    public void setIsDel(Boolean isDel) {
        this.data.setIsDel(isDel);
    }


}
