package com.ygbc.brain.common.interceptor;

import com.ygbc.brain.common.utils.ClassUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class})
})
public class MybatisAutoMapperInterceptor implements Interceptor {

    private final static Pattern humpPattern = Pattern.compile("[A-Z]");
    private static Logger logger = LoggerFactory.getLogger(MybatisAutoMapperInterceptor.class);

    /**
     * 拦截处理
     *
     * @param invocation
     */
    private void process(Invocation invocation) {
        //获取所有请求参数
        final Object[] args = invocation.getArgs();
        final MappedStatement ms = (MappedStatement) args[0];
        final Object parameter = args[1];
        BoundSql boundSql = ms.getBoundSql(parameter);
        String mapperSql = boundSql.getSql();
        String newMapperSql = this.getExecuteSql(ms, parameter.getClass(), mapperSql, parameter);
        if (StringUtils.isBlank(newMapperSql)) {
            return;
        }
        logger.info("使用插件处理SQL语句");
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), newMapperSql, boundSql.getParameterMappings(), parameter);
        RawSqlSource sqlSource = new RawSqlSource(ms.getConfiguration(), newBoundSql.getSql(), parameter.getClass());
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), sqlSource, ms.getSqlCommandType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuffer keyProperties = new StringBuffer();
            String[] arr$ = ms.getKeyProperties();
            int len$ = arr$.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                String keyProperty = arr$[i$];
                keyProperties.append(keyProperty).append(",");
            }

            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        MappedStatement newMs = builder.build();
        args[0] = newMs;
    }

    private String getExecuteSql(MappedStatement ms, Class<?> clazz, String mapperSql, Object param) {
        try {
            String[] commands = this.analysisSqlCommand(mapperSql);
            switch (commands[0]) {
                case "$plugin.insert":
                    return this.getInsertSqlStatement(ms, commands[1], clazz, param, true);
                case "$plugin.insertForce":
                    return this.getInsertSqlStatement(ms, commands[1], clazz, param, false);
                case "$plugin.update":
                    return this.getUpdateSqlStatement(ms, commands[1], clazz, param, true);
                case "$plugin.updateForce":
                    return this.getUpdateSqlStatement(ms, commands[1], clazz, param, false);
                case "$plugin.delete":
                    return this.getDeleteSqlStatement(commands[1], clazz);
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("处理SQL异常", e);
        }
        return null;
    }

    private String[] analysisSqlCommand(String sqlCommand) {
        String[] commands = new String[2];
        if (sqlCommand.contains("(")) {
            commands[0] = sqlCommand.substring(0, sqlCommand.indexOf("(")).trim();
            commands[1] = sqlCommand.substring(sqlCommand.indexOf("(") + 1).replace(")", "").trim();
        } else {
            commands[0] = sqlCommand;
            commands[1] = "";
        }
        return commands;
    }

    private ResultMap getResultMap(MappedStatement ms) {
        try {
            String id = ms.getId().substring(0, ms.getId().lastIndexOf(".") + 1) + "BaseResultMap";
            return ms.getConfiguration().getResultMap(id);
        } catch (Exception e) {
            logger.error("获取字段印射关系失败,", e);
        }
        return null;
    }

    private Map<String, ResultMapping> getJdbcTypeMap(MappedStatement ms) {
        ResultMap resultMap = this.getResultMap(ms);
        if (resultMap != null) {
            List<ResultMapping> resultMappingList = resultMap.getResultMappings();
            if (CollectionUtils.isNotEmpty(resultMappingList)) {
                Map<String, ResultMapping> resultMappingMap = new HashMap<>();
                for (ResultMapping resultMapping : resultMappingList) {
                    resultMappingMap.put(resultMapping.getProperty(), resultMapping);
                }
                return resultMappingMap;
            }
        }
        return null;
    }

    private String getJdbcType(Map<String, ResultMapping> resultMappingMap, String fieldName) {
        if (resultMappingMap != null) {
            ResultMapping resultMapping = resultMappingMap.get(fieldName);
            if (resultMapping != null) {
                JdbcType jdbcType = resultMapping.getJdbcType();
                if (jdbcType != null) {
                    return jdbcType.name();
                }
            }
        }
        return null;
    }

    private String getInsertSqlStatement(MappedStatement ms, String tableName, Class<?> clazz, Object param, boolean isSelective) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder intoSql = new StringBuilder();
        StringBuilder valueSql = new StringBuilder();
        Map<String, ResultMapping> resultMappingMap = this.getJdbcTypeMap(ms);
        if (StringUtils.isNotBlank(tableName)) {
            sql.append("insert into " + tableName);
        } else {

        }
        List<Field> fields = this.getClassFields(null, clazz);
        intoSql.append("(");
        valueSql.append(" values (");
        for (Field field : fields) {
            if (!isSelective && "-id-".contains(field.getName())) {
                continue;
            }
            if ("-createTime-updateBy-updateTime-ver-isDel-".contains(field.getName())) {
                continue;
            }
            Object value = field.get(param);
            if (value != null || (!isSelective)) {
                intoSql.append(this.getColumnName(field.getName())).append(",");
                valueSql.append("#{").append(field.getName());
                String jdbcType = this.getJdbcType(resultMappingMap, field.getName());
                if (StringUtils.isNotBlank(jdbcType)) {
                    valueSql.append(",jdbcType=").append(jdbcType);
                }
                valueSql.append("},");
            }
        }
        return sql.append(intoSql.substring(0, intoSql.length() - 1)).append(") ").append(valueSql.substring(0, valueSql.length() - 1)).append(")").toString();
    }

    private String getUpdateSqlStatement(MappedStatement ms, String tableName, Class<?> clazz, Object param, boolean isSelective) throws Exception {
        StringBuilder sql = new StringBuilder();
        StringBuilder updateSql = new StringBuilder();
        Map<String, ResultMapping> resultMappingMap = this.getJdbcTypeMap(ms);
        if (StringUtils.isNotBlank(tableName)) {
            sql.append("update " + tableName);
        } else {

        }
        sql.append(" set ");
        List<Field> fields = this.getClassFields(null, clazz);
        for (Field field : fields) {
            if ("-id-createBy-createTime-updateTime-".contains(field.getName())) {
                continue;
            }
            Object value = field.get(param);
            if (value != null || (!isSelective)) {
                updateSql.append(this.getColumnName(field.getName())).append(" = #{").append(field.getName());
                String jdbcType = this.getJdbcType(resultMappingMap, field.getName());
                if (StringUtils.isNotBlank(jdbcType)) {
                    updateSql.append(",jdbcType=").append(jdbcType);
                }
                updateSql.append("},");
            }
        }
        updateSql.append("ver = ver + 1");
        sql.append(updateSql);
        sql.append(" where id = #{id,jdbcType=BIGINT}");
        return sql.toString();
    }

    private String getDeleteSqlStatement(String tableName, Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        if (StringUtils.isNotBlank(tableName)) {
            sql.append("delete from " + tableName);
        } else {

        }
        return sql.append(" where id = #{id,jdbcType=BIGINT}").toString();
    }

    private List<Field> getClassFields(List<Field> list, Class<?> clazz) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class fieldClass = field.getType();
            if ( Modifier.isStatic(field.getModifiers())){
                continue;
            }
            list.add(field);
        }
        if (clazz.getSuperclass() != null) {
            return this.getClassFields(list, clazz.getSuperclass());
        }
        return list;
    }

    private String getColumnName(String fieldName) {
        Matcher matcher = humpPattern.matcher(fieldName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        this.process(invocation);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
