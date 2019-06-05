/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQTopicPublisher.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq.topic;

import javax.jms.Destination;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * ActiveMQTopicPublisher ActiveMQ主题消息发布者
 * 
 * @author：youngzil@163.com
 * @2018年10月30日 下午5:13:55
 * @since 1.0
 */
@Component
public class ActiveMQTopicPublisher {
    private final static Logger logger = LoggerFactory.getLogger(ActiveMQTopicPublisher.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发布主题消息
     */
    public void publishMsg(String destinationName, String message) {
        logger.info("发布了一条主题{}消息{}。", destinationName, message);
        Destination destination = new ActiveMQTopic(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
