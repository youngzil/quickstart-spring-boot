package org.quickstart.spring.boot.web.quartz.demo2;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quickstart.spring.boot.web.quartz.demo2.AutowiringSpringBeanJobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by david on 2015-01-20.
 */
@Configuration
// @ConditionalOnProperty(name = "quartz.enabled")
public class SchedulerConfig {

    @Autowired
    private AutowiringSpringBeanJobFactory springJobFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springJobFactory);
        schedulerFactoryBean.setConfigLocation(resourceLoader.getResource("classpath:/quartz.properties"));
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }

    // @Bean
    // public Properties quartzProperties() throws IOException {
    // PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
    // propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
    // propertiesFactoryBean.afterPropertiesSet();
    //
    // return propertiesFactoryBean.getObject();
    // }

}
