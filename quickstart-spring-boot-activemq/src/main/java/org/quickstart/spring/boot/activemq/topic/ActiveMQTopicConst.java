/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQTopicConst.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq.topic;

/**
 * ActiveMQTopicConst ActiveMQ主题常量
 * 
 * @author：yangzl@asiainfo.com
 * @2018年10月30日 下午5:13:18
 * @since 1.0
 */
public class ActiveMQTopicConst {

    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置，工厂标识
     */
    public static final String BEAN_NAME_JMSLISTENERCONTAINERFACTORY = "topicJmsListenerContainerFactory";

    /**
     * 主题消息标识_WebSocket的系统公告
     */
    public static final String TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE = "topic.websocket.system.notice";
}
