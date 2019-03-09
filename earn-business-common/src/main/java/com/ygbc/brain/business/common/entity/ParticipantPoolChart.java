package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.business.common.dal.data.UserPoolRecordData;
import com.ygbc.brain.business.common.module.Platform;

public class ParticipantPoolChart extends AttributeEntity<ParticipantPoolChart, ParticipantPoolChartData> implements
        Comparable<ParticipantPoolChart> {

    public ParticipantPoolChart() {

    }

    public ParticipantPoolChart(ParticipantPoolChartData data) {
        super(data);
    }

    public Long getParticipantPoolChartId() {
        return data.getParticipantPoolChartId();
    }

    public void setParticipantPoolChartId(Long participantPoolChartId) {
        data.setParticipantPoolChartId(participantPoolChartId);
    }

    public Long getUserPoolRecordId() {
        return data.getUserPoolRecordId();
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        data.setUserPoolRecordId(userPoolRecordId);
    }

    public Long getPoolId() {
        return data.getPoolId();
    }

    public void setPoolId(Long poolId) {
        data.setPoolId(poolId);
    }

    public Long getUserId() {
        return data.getUserId();
    }

    public void setUserId(Long userId) {
        data.setUserId(userId);
    }

    public String getUserNickName() {
        return data.getUserNickName();
    }

    public void setUserNickName(String userNickName) {
        data.setUserNickName(userNickName);
    }

    public Integer getParticipateTimes() {
        return data.getParticipateTimes();
    }

    public void setParticipateTimes(Integer participateTimes) {
        data.setParticipateTimes(participateTimes);
    }

    public Integer getSuccessTimes() {
        return data.getSuccessTimes();
    }

    public void setSuccessTimes(Integer successTimes) {
        data.setSuccessTimes(successTimes);
    }

    public Integer getEarnings() {
        return data.getEarnings();
    }

    public void setEarnings(Integer earnings) {
        data.setEarnings(earnings);
    }

    public Integer getPosition() {
        return data.getPosition();
    }

    public void setPosition(Integer position) {
        data.setPosition(position);
    }

    public String getStatus() {
        return data.getStatus();
    }

    public void setStatus(String status) {
        data.setStatus(status);
    }

    public void save(){
        if(data != null){
            if(data.getId() != null){
                Platform.sdbUpdate(data);
            }else{
                Platform.sdbInsert(data);
            }
        }
    }

    @Override
    public int compareTo(ParticipantPoolChart o) {
        int result;
        if(this.getPosition() != null && o.getPosition() != null){
            if ((result = Integer.compare(o.getPosition(),this.getPosition())) != 0) {
                return result;
            }
        }
        if(this.getEarnings() != null && o.getEarnings() != null){
            if ((result = Integer.compare(o.getEarnings(),this.getEarnings())) != 0) {
                return result;
            }
        }
        return o.getCreateTime().compareTo(this.getCreateTime());
    }
}
