package com.config.batis;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author
 * @version 1.0
 * @date 2025/5/14
 */

@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
)})
public class SlowSqlInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(SlowSqlInterceptor.class);
    private long threshold = 1000; // 默认1秒，可根据需要调整阈值


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("................{}", "SlowSqlInterceptor...慢sql");//每次有sql执行的时候
        long startTime = System.currentTimeMillis();
        Object result = invocation.proceed(); // 执行目标方法执行sql部分其他不受影响
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        if (duration > threshold) {
            Statement statement = (Statement) invocation.getArgs()[0];
            String sql = statement.toString(); // 获取执行的SQL语句，注意这里可能需要根据实际情况调整获取SQL的方式，因为statement可能被包装了多次。
            log.warn("SLOW SQL Detected: {} took {} ms", sql, duration);
        }
        return result;
    }

    @Override
    public void setProperties(Properties properties) {
        if (properties != null) {
            String thresholdStr = properties.getProperty("threshold");
            if (thresholdStr != null) {
                threshold = Long.parseLong(thresholdStr);
            }
        }
    }


}

