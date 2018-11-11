/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQTopicSubscriber.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ActiveMQTopicSubscriber ActiveMQ主题消息订阅者
 * 
 * @author：youngzil@163.com
 * @2018年10月30日 下午5:14:34
 * @since 1.0
 */
@Component
public class ActiveMQTopicSubscriber {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQTopicSubscriber.class);

    @JmsListener(destination = ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, containerFactory = ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void subscribeTopicWebsocketSystemNoticeMsg(String message) {
        logger.info("消费了一条主题{}消息{}。", ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, message);
    }
}
