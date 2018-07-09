/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：QueueConfig.java
 * 版本信息：
 * 日期：2017年8月3日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QueueConfig
 * 
 * @author：yangzl@asiainfo.com
 * @2017年8月3日 下午12:34:51
 * @version 2.0
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

}
