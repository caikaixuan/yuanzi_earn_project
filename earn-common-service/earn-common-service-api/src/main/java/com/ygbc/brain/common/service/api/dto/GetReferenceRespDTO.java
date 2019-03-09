package com.ygbc.brain.common.service.api.dto;

import com.ygbc.brain.base.dto.BaseDTO;

public class GetReferenceRespDTO extends BaseDTO {

    private String reference;

    public GetReferenceRespDTO() {
    }

    public GetReferenceRespDTO(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
