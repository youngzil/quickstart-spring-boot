package org.quickstart.spring.boot.web.interceptor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.core.env.Environment;

/**
 * sql查询语句是根据mysql和oracle的不同进行替换语句
 *
 * @Author guozq5 [guozq5@yangzl.com]
 * @Date 2018/5/23
 * @Time 11:22
 **/
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class ExamineMessageSqlInterceptor implements Interceptor {
    private static String dbType = "mysql";
    private static final String FIELD_NAME = "sql";
    private static final DefaultReflectorFactory REFLECTOR_FACTORY = new DefaultReflectorFactory();

    private static Environment environment;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
            MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, REFLECTOR_FACTORY);
            MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
            String id = mappedStatement.getId();
            BoundSql boundSql = statementHandler.getBoundSql();
            String sourceSql = boundSql.getSql();
            if (dbType.equals("oracle")) {
                sourceSql = sourceSql.replace("DATE_FORMAT", "TO_DATE");
                sourceSql = sourceSql.replace("NOW()", "SYSDATE");
                sourceSql = sourceSql.replace("%Y-%m-%d %H:%i:%s", "yyyy-MM-dd hh24:mi:ss");
                setFieldValue(boundSql, sourceSql);
            }

        }
        return invocation.proceed();
    }

    private static void setFieldValue(Object srcObj, Object valObj) throws IllegalArgumentException, IllegalAccessException {
        Field field = getField(srcObj.getClass(), FIELD_NAME);
        if (field != null) {
            field.set(srcObj, valObj);
        }
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        if (null == environment) {
            environment = ApplicationContextUtils.getBean(Environment.class);
        }
        String dbTemp = environment.getProperty("spring.datasource.driver-class-name");
        if (dbTemp.indexOf("oracle") > -1) {
            dbType = "oracle";
        }

    }

    private static Field getField(Class<?> clazz, String name) {
        Field field = null;
        for (Field f : clazz.getDeclaredFields()) {
            if (f.getName().equals(name)) {
                f.setAccessible(true);
                field = f;
                break;
            }
        }
        return field;
    }
}
