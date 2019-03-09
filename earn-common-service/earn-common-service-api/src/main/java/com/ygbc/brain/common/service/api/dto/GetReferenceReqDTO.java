package com.ygbc.brain.common.service.api.dto;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

public class GetReferenceReqDTO extends BaseDTO {

    @NotBlank(message = "编码类型不能为空")
    private String referenceType;

    public GetReferenceReqDTO() {
    }

    public GetReferenceReqDTO(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }
}
