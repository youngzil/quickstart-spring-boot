/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQQueueConst.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq.queue;

/**
 * ActiveMQQueueConst ActiveMQ队列常量
 * 
 * @author：youngzil@163.com
 * @2018年10月30日 下午5:09:06
 * @since 1.0
 */
public class ActiveMQQueueConst {

    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置，工厂标识
     */
    public static final String BEAN_NAME_JMSLISTENERCONTAINERFACTORY = "queueJmsListenerContainerFactory";

    /**
     * 队列消息标识_WebSocket的Java老司机聊天室
     */
    public static final String QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ = "queue.websocket.chatroom.javalsj";

}
