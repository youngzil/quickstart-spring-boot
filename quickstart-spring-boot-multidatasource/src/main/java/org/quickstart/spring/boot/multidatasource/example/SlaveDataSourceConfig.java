/**
 * 项目名称：msgframe-web 
 * 文件名：DataSourceConfig.java
 * 版本信息：
 * 日期：2018年8月14日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.multidatasource.example;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * DataSourceConfig
 * 
 * @author：yangzl@asiainfo.com
 * @2018年8月14日 下午7:48:14
 * @since 1.0
 */
@Configuration
public class SlaveDataSourceConfig {

    @Primary
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.db1") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}
