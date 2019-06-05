/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQQueueProducer.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq.queue;

import javax.jms.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * ActiveMQQueueProducer ActiveMQ消息生产者
 * 
 * @author：youngzil@163.com
 * @2018年10月30日 下午5:09:38
 * @since 1.0
 */
@Component
public class ActiveMQQueueProducer {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQQueueProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送队列消息
     * 
     * @param destinationName 消息目的地标识
     * @param message 消息文本
     */
    public void sendMsg(String destinationName, String message) {
        logger.info("发布了一条队列{}消息{}。", destinationName, message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
