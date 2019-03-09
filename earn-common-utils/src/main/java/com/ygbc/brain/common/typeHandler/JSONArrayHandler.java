package com.ygbc.brain.common.typeHandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({JSONArray.class})
public class JSONArrayHandler extends BaseTypeHandler <JSONArray>{
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, JSONArray jsonArray, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, jsonArray.toString());
    }

    @Override
    public JSONArray getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return JSONObject.parseArray(resultSet.getString(s));
    }

    @Override
    public JSONArray getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return JSONObject.parseArray(resultSet.getString(i));
    }

    @Override
    public JSONArray getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return JSONObject.parseArray(callableStatement.getString(i));
    }
}
