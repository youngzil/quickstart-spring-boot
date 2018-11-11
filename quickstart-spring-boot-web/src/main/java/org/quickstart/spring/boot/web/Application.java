/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：App.java
 * 版本信息：
 * 日期：2017年5月7日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.quickstart.spring.boot.web.common.MyFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.github.pagehelper.PageHelper;

/**
 * App
 * 
 * @author：youngzil@163.com
 * @2017年5月7日 下午12:14:46
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = "org.quickstart.spring.boot.quartz.demo3") // 1 包含@Configuration//配置控制 @EnableAutoConfiguration//启用自动配置 @ComponentScan//组件扫描
@MapperScan(basePackages = "org.quickstart.spring.boot.dao") // 2 设置mybatis的扫描路径
@EnableJms // 3 启动jms
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        logger.info("My Spring Boot Application Started");
    }

    @Bean
    public PageHelper pageHelper() {
        // System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        MyFilter httpBasicFilter = new MyFilter();
        registrationBean.setFilter(httpBasicFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}
