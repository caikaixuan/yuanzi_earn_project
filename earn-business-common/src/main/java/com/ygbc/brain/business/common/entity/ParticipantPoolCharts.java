package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.data.ParticipantPoolChartData;
import com.ygbc.brain.business.common.enums.ParticipantPoolChartStatus;
import com.ygbc.brain.business.common.module.Platform;

import java.util.*;

public class ParticipantPoolCharts extends AttributeEntity<ParticipantPoolCharts, ParticipantPoolChartData> {

    private boolean ranked = false;

    private Pool pool;

    private List<ParticipantPoolChart> charts = new ArrayList<>();

    public ParticipantPoolCharts(Pool pool) {
        this.pool = pool;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public List<ParticipantPoolChart> getCharts() {
        return charts;
    }

    public void setCharts(List<ParticipantPoolChart> charts) {
        this.charts = charts;
    }

    public boolean isRanked() {
        return ranked;
    }

    public void setRanked(boolean ranked) {
        this.ranked = ranked;
    }

    public boolean isNewWinner(long userId){
        for(ParticipantPoolChart participantPoolChart : this.charts){
            if(participantPoolChart.getUserId() == userId){
                return false;
            }
        }
        return true;
    }

    public void addParticipantPoolChart(ParticipantPoolChart participantPoolChart) {
        if (participantPoolChart != null) {
            this.charts.add(participantPoolChart);
        }
    }

    public List<ParticipantPoolChart> fill() {
        Iterator<ParticipantPoolChart> iterator = this.charts.iterator();
        while (iterator.hasNext()) {
            ParticipantPoolChart participantPoolChart = iterator.next();
            long userId = participantPoolChart.getUserId();
            int participateTimes = pool.getUserParticipateTimes(userId);
            int successTimes = pool.getUserSuccessTimes(userId);
            int totalEarning = pool.getUserTotalEarning(userId);
            participantPoolChart.setParticipateTimes(participateTimes);
            participantPoolChart.setSuccessTimes(successTimes);
            participantPoolChart.setEarnings(totalEarning);
            participantPoolChart.setStatus(ParticipantPoolChartStatus.EFFECTIVE.getValue());
        }
        return this.charts;
    }

    public boolean rank(){
        if(!pool.getPoolRecordCharts().isRanked()){
            return false;
        }
        if(!ranked){
            int position = 1;
            fill();
            Collections.sort(this.charts);
            Iterator<ParticipantPoolChart> iterator = this.charts.iterator();
            while(iterator.hasNext()){
                ParticipantPoolChart participantPoolChart = iterator.next();
                participantPoolChart.setPosition(position++);
            }
            this.setRanked(true);
        }
        return true;
    }

    public void save(){
        if(pool.isRanked() && isRanked()){
            for(ParticipantPoolChart participantPoolChart : charts){
                participantPoolChart.save();
            }
        }
    }
}
