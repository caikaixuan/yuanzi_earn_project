package com.ygbc.brain.common.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.regex.Pattern;

@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class})
})
public class MybatisAutoMapperInterceptor1 implements Interceptor {

    /**
     * 日志记录器
     */
    private final static Logger logger = LoggerFactory.getLogger(MybatisAutoMapperInterceptor.class);

    /**
     * 实体与数据库映射需要替换字符串的正则表达式
     */
    private final static Pattern humpPattern = Pattern.compile("[A-Z]");

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

    /**
     * 插件处理
     *
     * @param invocation
     */
    private void process(Invocation invocation) {

    }
}
