package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.PoolData;
import com.ygbc.brain.business.common.enums.PoolStatus;
import com.ygbc.brain.business.common.module.Platform;

import java.util.*;

public class Pool extends AttributeEntity<Pool,PoolData> {

    private boolean ranked = false;

    private PoolRecordCharts poolRecordCharts = new PoolRecordCharts(this);

    private ParticipantPoolCharts participantPoolCharts = new ParticipantPoolCharts(this);

    private Map<Long, List<UserPoolRecord>> userPoolRecords = new HashMap<>();

    public Pool(){
        
    }

    public Pool(PoolData data){
        super(data);
    }

    public Pool(PoolData data,PoolRecordCharts poolRecordCharts,ParticipantPoolCharts participantPoolCharts,Map<Long, List<UserPoolRecord>> userPoolRecords){
        super(data);
        this.poolRecordCharts = poolRecordCharts;
        this.participantPoolCharts = participantPoolCharts;
        this.userPoolRecords = userPoolRecords;
    }

    public Long getPoolId() {
        return data.getPoolId();
    }

    public void setPoolId(Long poolId) {
        data.setPoolId(poolId); 
    }

    public Integer getInitIntegration() {
        return data.getInitIntegration();
    }

    public void setInitIntegration(Integer initIntegration) {
        data.setInitIntegration(initIntegration);
    }

    public Integer getInitParticipateIntegration() {
        return data.getInitParticipateIntegration();
    }

    public void setInitParticipateIntegration(Integer initParticipateIntegration) {
        data.setInitParticipateIntegration(initParticipateIntegration);
    }

    public Integer getIntegrationMax() {
        return data.getIntegrationMax();
    }

    public void setIntegrationMax(Integer IntegeregrationMax) {
        data.setIntegrationMax(IntegeregrationMax); 
    }

    public Integer getIntegrationMin() {
        return data.getIntegrationMin();
    }

    public void setIntegrationMin(Integer IntegeregrationMin) {
        data.setIntegrationMin(IntegeregrationMin);
    }

    public Integer getPlanParticipationRate() {
        return data.getPlanParticipationRate();
    }

    public void setPlanParticipationRate(Integer planParticipationRate) {
        data.setPlanParticipationRate(planParticipationRate);
    }

    public Integer getPlanParticipantRate() {
        return data.getPlanParticipantRate();
    }

    public void setPlanParticipantRate(Integer planParticipantRate) {
        data.setPlanParticipantRate(planParticipantRate);
    }

    public Integer getCurrentParticipationRate() {
        return data.getCurrentParticipationRate();
    }

    public void setCurrentParticipationRate(Integer currentParticipationRate) {
        data.setCurrentParticipationRate(currentParticipationRate);
    }

    public Integer getCurrentParticipantRate() {
        return data.getCurrentParticipantRate();
    }

    public void setCurrentParticipantRate(Integer currentParticipantRate) {
        data.setCurrentParticipantRate(currentParticipantRate);
    }

    public Integer getCurrentIntegration() {
        return data.getCurrentIntegration();
    }

    public void setCurrentIntegration(Integer currentIntegration) {
        data.setCurrentIntegration(currentIntegration);
        if(50000 <= currentIntegration && currentIntegration < 100000){
            data.setCurrentParticipateIntegration(200);
        }
        if(100000 <= currentIntegration && currentIntegration <200000){
            data.setCurrentParticipateIntegration(300);
        }
        if(200000 <= currentIntegration && currentIntegration <300000){
            data.setCurrentParticipateIntegration(400);
        }
        if(300000 <= currentIntegration && currentIntegration <400000){
            data.setCurrentParticipateIntegration(500);
        }
        if(400000 <= currentIntegration && currentIntegration <500000){
            data.setCurrentParticipateIntegration(500);
        }
        if(currentIntegration >= this.getIntegrationMax()){
            this.setStatus(PoolStatus.LOCKED.getValue());
        }
    }

    public Integer getCurrentParticipateIntegration() {
        return data.getCurrentParticipateIntegration();
    }

    public void setCurrentParticipateIntegration(Integer currentParticipateIntegration) {
        data.setCurrentParticipateIntegration(currentParticipateIntegration);
    }

    public Integer getParticipantNum() {
        return data.getParticipantNum();
    }

    public void setParticipantNum(Integer participantNum) {
        data.setParticipantNum(participantNum);
    }

    public Integer getParticipationTimes() {
        return data.getParticipationTimes();
    }

    public void setParticipationTimes(Integer participationTimes) {
        data.setParticipationTimes(participationTimes);
    }

    public Integer getWinnerNum() {
        return data.getWinnerNum();
    }

    public void setWinnerNum(Integer winnerNum) {
        data.setWinnerNum(winnerNum);
    }

    public Integer getSuccessTimes() {
        return data.getSuccessTimes();
    }

    public void setSuccessTimes(Integer successTimes) {
        data.setSuccessTimes(successTimes);
    }

    public Integer getPlanPeriod() {
        return data.getPlanPeriod();
    }

    public void setPlanPeriod(Integer period) {
        data.setPlanPeriod(period);
    }

    public Date getPlanEndTime() {
        return data.getPlanEndTime();
    }

    public void setPlanEndTime(Date endTime) {
        data.setPlanEndTime(endTime);
    }

    public Integer getActuallyPeriod() {
        return data.getActuallyPeriod();
    }

    public void setActuallyPeriod(Integer actuallyPeriod) {
        data.setActuallyPeriod(actuallyPeriod);
    }

    public Date getActuallyEndTime() {
        return data.getActuallyEndTime();
    }

    public void setActuallyEndTime(Date actuallyEndTime) {
        data.setActuallyEndTime(actuallyEndTime);
    }

    public Integer getAwardIntegration() {
        return data.getAwardIntegration();
    }

    public void setAwardIntegration(Integer awardIntegration) {
        data.setAwardIntegration(awardIntegration);
    }

    public Integer getProfitIntegration() {
        return data.getProfitIntegration();
    }

    public void setProfitIntegration(Integer profitIntegration) {
        data.setProfitIntegration(profitIntegration);
    }

    public Boolean getIsEarn() {
        return data.getIsEarn();
    }

    public void setIsEarn(Boolean isEarn) {
        data.setIsEarn(isEarn);
    }

    public Boolean getNeedMeddle() {
        return data.getNeedMeddle();
    }

    public void setNeedMeddle(Boolean needMeddle) {
        data.setNeedMeddle(needMeddle);
    }

    public String getStatus() {
        return data.getStatus();
    }

    public void setStatus(String status) {
        data.setStatus(status);
    }

    public PoolRecordCharts getPoolRecordCharts() {
        return poolRecordCharts;
    }

    public void setPoolRecordCharts(PoolRecordCharts poolRecordCharts) {
        this.poolRecordCharts = poolRecordCharts;
        this.poolRecordCharts.setPool(this);
    }

    public ParticipantPoolCharts getParticipantPoolCharts() {
        return participantPoolCharts;
    }

    public void setParticipantPoolCharts(ParticipantPoolCharts participantPoolCharts) {
        this.participantPoolCharts = participantPoolCharts;
    }

    public Map<Long, List<UserPoolRecord>> getUserPoolRecords() {
        return userPoolRecords;
    }

    public void setUserPoolRecords(Map<Long, List<UserPoolRecord>> userPoolRecords) {
        this.userPoolRecords = userPoolRecords;
    }

    public boolean isRanked() {
        return ranked;
    }

    public void setRanked(boolean ranked) {
        this.ranked = ranked;
    }

    public boolean isNewParticipant(long userId){
        return !this.userPoolRecords.containsKey(userId);
    }

    public boolean isNewWinner(long userId){
        return this.participantPoolCharts.isNewWinner(userId);
    }

    public boolean canChallenge(){
        String status = getStatus();
        if(PoolStatus.LOCKED.getValue().equals(status) || PoolStatus.DONE.getValue().equals(status) || getPlanEndTime()
                .compareTo(new Date()) < 0){
            return true;
        }
        return false;
    }

    public UserPoolRecord getUserPoolRecord(long userId,long userPoolRecordId){
        if(userPoolRecords.containsKey(userId)){
            List<UserPoolRecord> userPoolRecordList = userPoolRecords.get(userId);
            for(UserPoolRecord userPoolRecord : userPoolRecordList){
                if(userPoolRecord.getUserPoolRecordId() == userPoolRecordId){
                    return userPoolRecord;
                }
            }
        }
        return null;
    }

    public List<UserPoolRecord> getUserRecords(long userId){
        if(userPoolRecords.containsKey(userId)){
            return userPoolRecords.get(userId);
        }
        return null;
    }

    public int getUserParticipateTimes(long userId){
        int times = 0;
        List<UserPoolRecord> userPoolRecordList = getUserRecords(userId);
        if(userPoolRecordList != null && userPoolRecordList.size() > 0){
            times = userPoolRecordList.size();
        }
        return times;
    }

    public int getUserSuccessTimes(long userId){
        int times = 0;
        List<UserPoolRecord> userPoolRecordList = getUserRecords(userId);
        if(userPoolRecordList != null && userPoolRecordList.size() > 0){
            for(UserPoolRecord userPoolRecord : userPoolRecordList){
                if(userPoolRecord.getResult()){
                    times++;
                }
            }
        }
        return times;
    }

    public int getUserTotalEarning(long userId){
        int totalEarning = 0;
        if(this.poolRecordCharts.isRanked()){
            totalEarning = this.poolRecordCharts.getUserTotalEarning(userId);
        }
        return totalEarning;
    }

    public void addParticipationTimes(){
        int participationTimes = this.getParticipationTimes() != null ? this.getParticipationTimes():0;
        this.setParticipationTimes(participationTimes + 1);
        calculateParticipationRate();
    }

    public void addSuccessTimes(){
        int successTimes= this.getSuccessTimes() != null ? this.getSuccessTimes():0;
        this.setSuccessTimes(successTimes + 1);
        calculateParticipationRate();
    }

    public void addNewParticipant(){
        int participantNum = this.getParticipantNum() != null ? this.getParticipantNum():0;
        this.setParticipantNum( participantNum + 1);
        calculateParticipantRate();
    }

    public void addWinnerNum(){
        int winner = this.getWinnerNum() != null ? this.getWinnerNum():0;
        this.setWinnerNum(winner + 1);
        calculateParticipantRate();
    }

    public void addIntegration(int integration){
        int currentIntegration = this.getCurrentIntegration() != null ? this.getCurrentIntegration():0;
        this.setCurrentIntegration(currentIntegration + integration);
    }

    public void addUserPoolRecord(UserPoolRecord userPoolRecord){
        if(userPoolRecord != null){
            long userId = userPoolRecord.getUserId();
            int addIntegration = userPoolRecord.getConsumeIntegration();
            List<UserPoolRecord> userPoolRecordList = new ArrayList<>();
            if(this.userPoolRecords.containsKey(userId)){
                userPoolRecordList = userPoolRecords.get(userId);
            }else{
                addNewParticipant();
            }
            addParticipationTimes();
            addIntegration(addIntegration);
            userPoolRecordList.add(userPoolRecord);
            userPoolRecords.put(userId,userPoolRecordList);
        }
    }

    public void addPoolRecordChart(PoolRecordChart poolRecordChart){
        addSuccessTimes();
        this.poolRecordCharts.addPoolRecordChart(poolRecordChart);
    }

    public void addParticipantPoolChart(ParticipantPoolChart participantPoolChart){
        long userId = participantPoolChart.getUserId();
        if(isNewWinner(userId)){
            addWinnerNum();
            this.participantPoolCharts.addParticipantPoolChart(participantPoolChart);
        }
    }

    public void calculateParticipationRate(){
        int participationTimes = this.getParticipationTimes();
        int successTimes = this.getSuccessTimes();
        this.setCurrentParticipationRate((successTimes * 100 )/participationTimes);

    }

    public void calculateParticipantRate(){
        int participantNum = this.getParticipantNum();
        int winnerNum = this.getWinnerNum();
        this.setCurrentParticipantRate((winnerNum * 100)/participantNum);
    }

    public void runLottery(){
        if( !ranked ){
            Date now = new Date();
            Date startTime = this.getCreateTime();
            int period = (int) ((now.getTime() - startTime.getTime())/1000);
            this.poolRecordCharts.rank();
            this.participantPoolCharts.rank();
            this.setRanked(true);
            this.setStatus(PoolStatus.DONE.getValue());
            this.setActuallyEndTime(now);
            this.setActuallyPeriod(period);
            this.save();
        }

    }
    
    public void save(){
        if(data.getId() == null){
            Platform.sdbInsert(data);
        }else{
            Platform.sdbUpdate(data);
        }
        this.poolRecordCharts.save();
        this.participantPoolCharts.save();
    }

}
