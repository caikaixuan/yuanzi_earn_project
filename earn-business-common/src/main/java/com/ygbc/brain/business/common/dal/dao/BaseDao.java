package com.ygbc.brain.business.common.dal.dao;

import com.ygbc.brain.business.common.dal.data.BaseData;
import com.ygbc.brain.common.model.Page;

import java.util.List;
import java.util.Map;

public interface BaseDao {

    <T extends BaseData> T selectById(Long id);

    <T extends BaseData> T selectByCode(String code);

    <T extends BaseData> T selectOne(Map paramMap);

    int selectCount(Map paramMap);

    <T extends BaseData> List<T> select(Map paramMap);

    <T extends BaseData> List<T> select(Map paramMap, Page page);

    <T extends BaseData> int insert(T data);

    <T extends BaseData> int insertForce(T data);

    <T extends BaseData> int update(T data);

    <T extends BaseData> int updateForce(T data);

    <T extends BaseData> int delete(T data);
}