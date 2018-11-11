/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：Producer.java
 * 版本信息：
 * 日期：2017年8月3日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.activemq;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Producer
 * 
 * @author：youngzil@163.com
 * @2017年8月3日 下午9:15:10
 * @version 2.0
 */
@Service("producer2")
public class Producer2 {

    @Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
        System.out.println("从out.queue队列收到的回复报文为:" + text);
    }
}
