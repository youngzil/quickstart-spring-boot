/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQQueueConsumer.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ActiveMQQueueConsumer ActiveMQ队列消息消费者
 * 
 * @author：youngzil@163.com
 * @2018年10月30日 下午5:12:36
 * @since 1.0
 */
@Component
public class ActiveMQQueueConsumer {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQQueueConsumer.class);

    /**
     * WebSocket的Java老司机聊天室队列消息消费者
     */
    @JmsListener(destination = ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, containerFactory = ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void receiveQueueWebSocketJavalsjChatroomMsg(String message) {
        logger.info("消费了一条队列{}消息{}。", ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, message);
    }

}
