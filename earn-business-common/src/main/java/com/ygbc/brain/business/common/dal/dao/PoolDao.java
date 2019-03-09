package com.ygbc.brain.business.common.dal.dao;

import com.ygbc.brain.business.common.dal.data.PoolData;

import java.util.List;

public interface PoolDao extends BaseDao {
    List<PoolData> selectPoolToBeDone();

    int selectCountToBeDone();

}
