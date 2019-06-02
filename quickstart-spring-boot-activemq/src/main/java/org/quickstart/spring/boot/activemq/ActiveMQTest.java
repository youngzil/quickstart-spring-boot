/**
 * 项目名称：quickstart-spring-boot-activemq 
 * 文件名：ActiveMQTest.java
 * 版本信息：
 * 日期：2018年10月30日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq;

import java.time.Instant;
import org.quickstart.spring.boot.activemq.queue.ActiveMQQueueConst;
import org.quickstart.spring.boot.activemq.queue.ActiveMQQueueProducer;
import org.quickstart.spring.boot.activemq.topic.ActiveMQTopicConst;
import org.quickstart.spring.boot.activemq.topic.ActiveMQTopicPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ActiveMQTest
 * 
 * @author：youngzil@163.com
 * @2018年10月30日 下午5:15:12
 * @since 1.0
 */
@Component
@EnableScheduling
public class ActiveMQTest {

    @Autowired
    private ActiveMQQueueProducer activeMQQueueProducer;

    @Autowired
    private ActiveMQTopicPublisher activeMQTopicPublisher;

    @Scheduled(fixedRate = 10000, initialDelay = 3000)
    public void test() {
        activeMQQueueProducer.sendMsg(ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, "队列message" + Instant.now().toString());
        activeMQTopicPublisher.publishMsg(ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, "主题message" + Instant.now().toString());
    }

}
