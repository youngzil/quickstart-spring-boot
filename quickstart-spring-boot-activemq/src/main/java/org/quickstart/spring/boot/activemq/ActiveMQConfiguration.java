/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQConfiguration.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq;

import javax.jms.ConnectionFactory;

import org.quickstart.spring.boot.activemq.queue.ActiveMQQueueConst;
import org.quickstart.spring.boot.activemq.topic.ActiveMQTopicConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

/**
 * ActiveMQConfiguration ActiveMQ消息队列配置类
 * 
 * @author：yangzl@asiainfo.com
 * @2018年10月30日 下午5:08:11
 * @since 1.0
 */
@Configuration
public class ActiveMQConfiguration {

    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean(ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean(ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
