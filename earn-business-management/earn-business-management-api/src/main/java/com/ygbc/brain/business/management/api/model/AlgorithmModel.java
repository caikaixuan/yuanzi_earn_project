package com.ygbc.brain.business.management.api.model;

import com.alibaba.fastjson.JSONArray;
import com.ygbc.brain.base.model.BaseModel;

public class AlgorithmModel extends BaseModel{
    /**
     * 名称
     */
    private String name;

    /**
     * 算法中文名称
     */
    private String nameCn;

    /**
     * 算法英文名称
     */
    private String nameEn;

    /**
     * 算法描述
     */
    private String remark;

    /**
     * 参数列表
     */
    private JSONArray arguments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public JSONArray getArguments() {
        return arguments;
    }

    public void setArguments(JSONArray arguments) {
        this.arguments = arguments;
    }
}
