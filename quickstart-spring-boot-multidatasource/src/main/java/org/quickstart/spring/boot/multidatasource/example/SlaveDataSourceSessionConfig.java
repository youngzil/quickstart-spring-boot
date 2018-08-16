/**
 * 项目名称：msgframe-web 
 * 文件名：MybatisDbAConfig.java
 * 版本信息：
 * 日期：2018年8月14日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.multidatasource.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * MybatisDbAConfig
 * 
 * @author：yangzl@asiainfo.com
 * @2018年8月14日 下午7:49:29
 * @since 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.ai.aif.msgframe.dao"})
// @MapperScan(basePackages = "com.ai.aif.msgframe.dao", sqlSessionTemplateRef = "primarySqlSessionTemplate",sqlSessionFactoryRef = "primarySqlSessionFactory")
public class SlaveDataSourceSessionConfig {

    @Autowired
    @Qualifier("ds1")
    private DataSource ds1;

    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // @Primary
    // @Bean(name = "sqlSessionFactory1")
    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1); // 使用titan数据源, 连接titan库
        factoryBean.setTypeAliasesPackage("com.ai.aif.msgframe.entity");
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
        return template;
    }

    @Bean(name = "jdbcTemplate1")
    public JdbcTemplate jdbcTemplate1(@Qualifier("masterDataSource") DataSource dataSource) {
        return new JdbcTemplate(ds1);
        // return new JdbcTemplate(dataSource);
    }

    @Primary
    @Bean(name = "transactionManager1")
    public DataSourceTransactionManager transactionManager1(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(ds1);
        // return new DataSourceTransactionManager(dataSource);
    }

}
