package com.ygbc.brain.business.common.entity;

import com.ygbc.brain.business.common.dal.dao.PoolRecordChartDao;
import com.ygbc.brain.business.common.dal.data.PoolRecordChartData;
import com.ygbc.brain.business.common.enums.PoolRecordChartStatus;
import com.ygbc.brain.business.common.module.Platform;

import java.util.*;

public class PoolRecordCharts extends AttributeEntity<PoolRecordCharts,PoolRecordChartData> {

    private Pool pool;

    private boolean ranked = false;

    public PoolRecordCharts(){

    }

    public PoolRecordCharts(Pool pool) {
        this.pool = pool;
    }

    private List<PoolRecordChart> charts = new ArrayList<>();

    public List<PoolRecordChart> getCharts() {
        return charts;
    }

    public void setCharts(List<PoolRecordChart> charts) {
        this.charts = charts;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public boolean isRanked() {
        return ranked;
    }

    public void setRanked(boolean ranked) {
        this.ranked = ranked;
    }

    public void addPoolRecordChart(PoolRecordChart chart){
        if(chart.getGrade() == null || chart.getGrade() == 0){
            chart.calculateGrade(this.pool);
        }
        this.charts.add(chart);
    }

    public boolean rank(){
        if( !pool.isRanked() && !ranked ){
            Collections.sort(this.charts);
            Iterator<PoolRecordChart> iterator = this.charts.iterator();
            int position = 1;
            int awardIntegration = 0;
            while(iterator.hasNext()){
                PoolRecordChart chart = iterator.next();
                awardIntegration += chart.setAward(position++);
                chart.setStatus(PoolRecordChartStatus.EFFECTIVE.getValue());
            }
            this.pool.setAwardIntegration(awardIntegration);
            if(this.pool.getCurrentIntegration() > awardIntegration){
                this.pool.setIsEarn(true);
            }else{
                this.pool.setIsEarn(false);
            }
            this.pool.setProfitIntegration(this.pool.getCurrentIntegration() - awardIntegration - this.pool.getInitIntegration());
            this.setRanked(true);
        }
        return true;
    }


    public int getUserTotalEarning(long userId){
        Iterator<PoolRecordChart>iterator = this.charts.iterator();
        int totalEarning = 0;
        while(iterator.hasNext()){
            PoolRecordChart chart = iterator.next();
            if(chart.getUserId() == userId){
                totalEarning += chart.getAwardIntegration();
            }
        }
        return totalEarning;
    }

    public void save(){
        if(pool.isRanked() && this.isRanked()){
            for(PoolRecordChart poolRecordChart : charts){
                poolRecordChart.save();
            }
        }
    }

}
