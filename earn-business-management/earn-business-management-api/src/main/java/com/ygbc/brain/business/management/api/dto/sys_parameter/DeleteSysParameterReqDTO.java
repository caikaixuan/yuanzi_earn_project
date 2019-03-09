package com.ygbc.brain.business.management.api.dto.sys_parameter;

import com.ygbc.brain.base.dto.BaseDTO;

public class DeleteSysParameterReqDTO extends BaseDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
