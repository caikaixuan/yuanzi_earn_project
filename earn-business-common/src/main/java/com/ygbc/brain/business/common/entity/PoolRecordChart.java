package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.PoolRecordChartData;
import com.ygbc.brain.business.common.enums.AwardLevel;
import com.ygbc.brain.business.common.module.Platform;

import java.util.Date;

public class PoolRecordChart extends AttributeEntity<PoolRecordChart, PoolRecordChartData> implements Comparable<PoolRecordChart> {

    public PoolRecordChart() {

    }

    public PoolRecordChart(PoolRecordChartData data) {
        super(data);
    }

    public Long getPoolRecordChartId() {
        return this.data.getPoolRecordChartId();
    }

    public void setPoolRecordChartId(Long poolRecordChartId) {
        this.data.setPoolRecordChartId(poolRecordChartId);
    }

    public Long getUserPoolRecordId() {
        return this.data.getUserPoolRecordId();
    }

    public void setUserPoolRecordId(Long userPoolRecordId) {
        this.data.setUserPoolRecordId(userPoolRecordId);
    }

    public Long getPoolId() {
        return this.data.getPoolId();
    }

    public void setPoolId(Long poolId) {
        this.data.setPoolId(poolId);
    }

    public Long getUserId() {
        return this.data.getUserId();
    }

    public void setUserId(Long userId) {
        this.data.setUserId(userId);
    }

    public String getUserNickName() {
        return this.data.getUserNickName();
    }

    public void setUserNickName(String userNickName) {
        this.data.setUserNickName(userNickName);
    }

    public Integer getRightNum() {
        return this.data.getRightNum();
    }

    public void setRightNum(Integer rightNum) {
        this.data.setRightNum(rightNum);
    }

    public Integer getGrade() {
        return this.data.getGrade();
    }

    public void setGrade(Integer grade) {
        this.data.setGrade(grade);
    }

    public Integer getPosition() {
        return this.data.getPosition();
    }

    public void setPosition(Integer position) {
        this.data.setPosition(position);
    }

    public Integer getAwardLevel() {
        return this.data.getAwardLevel();
    }

    public void setAwardLevel(Integer awardLevel) {
        this.data.setAwardLevel(awardLevel);
    }

    public Integer getAwardIntegration() {
        return this.data.getAwardIntegration();
    }

    public void setAwardIntegration(Integer awardIntegration) {
        this.data.setAwardIntegration(awardIntegration);
    }

    public String getStatus() {
        return this.data.getStatus();
    }

    public void setStatus(String status) {
        this.data.setStatus(status);
    }

    public void calculateGrade(Pool pool) {
        Integer rightNumPart = getRightNum() * 50 / 7;
        Integer timePart = 50 * (int) (pool.getCreateTime().getTime() / getCreateTime().getTime());
        Integer grade = rightNumPart + timePart;
        setGrade(grade);
    }

    public Integer setAward(Integer position) {
        this.setPosition(position);
        if (position == 1) {
            this.setAwardLevel(AwardLevel.SPECIAL.getValue());
            this.setAwardIntegration(66600);
            return (66600);
        }
        if (position > 1 && position < 4) {
            this.setAwardLevel(AwardLevel.FIRST_PRIZE.getValue());
            this.setAwardIntegration(33300);
            return (33300);
        }
        if (position >= 4 && position < 9) {
            this.setAwardLevel(AwardLevel.SECOND_PRIZE.getValue());
            this.setAwardIntegration(15800);
            return (15800);
        }
        if (position >= 9 && position < 18) {
            this.setAwardLevel(AwardLevel.THIRD_PRIZE.getValue());
            this.setAwardIntegration(8800);
            return (8800);
        }
        if (position >= 18 && position < 37) {
            this.setAwardLevel(AwardLevel.FORTH_PRIZE.getValue());
            this.setAwardIntegration(5500);
            return (5500);
        }
        if (position >= 37 && position < 86) {
            this.setAwardLevel(AwardLevel.FIFTH_PRIZE.getValue());
            this.setAwardIntegration(3300);
            return (3300);
        }
        return 0;
    }

    public void save(){
        if(data != null){
            if(getId() != null){
                Platform.sdbUpdate(data);
            }else{
                Platform.sdbInsert(data);
            }
        }
    }

    @Override
    public int compareTo(PoolRecordChart o) {
        int result;
        if(this.getPosition() != null && o.getPosition() != null){
            if ((result = Integer.compare(o.getPosition(),this.getPosition())) != 0) {
                return result;
            }
        }
        if(this.getGrade() != null && o.getGrade() != null){
            if ((result = Integer.compare(o.getGrade(),this.getGrade())) != 0) {
                return result;
            }
        }
        return o.getCreateTime().compareTo(this.getCreateTime());
    }
}
