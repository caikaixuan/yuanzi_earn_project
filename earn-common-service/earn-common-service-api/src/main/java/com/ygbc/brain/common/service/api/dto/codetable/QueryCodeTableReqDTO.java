package com.ygbc.brain.common.service.api.dto.codetable;

import com.ygbc.brain.base.dto.BaseDTO;

public class QueryCodeTableReqDTO extends BaseDTO {

    private String tableName;

    private String language;

    private String code;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
