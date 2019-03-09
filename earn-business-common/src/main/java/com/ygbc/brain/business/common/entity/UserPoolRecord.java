package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.common.enums.TrueFalse;

import java.util.Date;

public class UserPoolRecord extends AttributeEntity<UserPoolRecord,UserPoolRecordData> {


    public UserPoolRecord(){

    }

    public UserPoolRecord(UserPoolRecordData data) {
        super(data);
    }

    public Long getUserPoolRecordId() {
        return data.getUserPoolRecordId();
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        data.setUserPoolRecordId(userPoolRecordId);
    }

    public Long getUserId() {
        return data.getUserId();
    }

    public void setUserId(Long userId) {
        data.setUserId(userId);
    }

    public Long getPoolId() {
        return data.getPoolId();
    }

    public void setPoolId(Long poolId) {
        data.setPoolId(poolId);
    }

    public String getUserNickName() {
        return data.getUserNickName();
    }

    public void setUserNickName(String userNickName) {
        data.setUserNickName(userNickName);
    }

    public Integer getConsumeIntegration() {
        return data.getConsumeIntegration();
    }

    public void setConsumeIntegration(Integer consumeIntegration) {
        data.setConsumeIntegration(consumeIntegration);
    }

    public Integer getRightNum() {
        return data.getRightNum();
    }

    public void setRightNum(Integer rightNum) {
        data.setRightNum(rightNum);
        if(rightNum >= SysParameter.getInstance().getData().getSuccessLine()){
            data.setResult(TrueFalse.TRUE.getValue());
        }else{
            data.setResult(TrueFalse.FALSE.getValue());
        }
    }

    public Boolean getResult() {
        return data.getResult();
    }

    public void setResult(Boolean result) {
        data.setResult(result);
    }

    public String getStatus() {
        return data.getStatus();
    }

    public void setStatus(String status) {
        data.setStatus(status);
    }

    public Long getId() {
        return data.getId();
    }

    public void setId(Long id) {
        data.setId(id);
    }


}
