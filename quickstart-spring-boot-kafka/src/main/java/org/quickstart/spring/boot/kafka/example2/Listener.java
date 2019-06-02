/**
 * 项目名称：quickstart-spring-boot-kafka 
 * 文件名：Listener.java
 * 版本信息：
 * 日期：2017年11月10日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.kafka.example2;

import java.util.Optional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Listener
 * 
 * @author：youngzil@163.com
 * @2017年11月10日 下午12:15:35
 * @since 1.0
 */
public class Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    /**
     * 监听kafka消息,如果有消息则消费,同步数据到新烽火的库
     * 
     * @param record 消息实体bean
     */
    @KafkaListener(topics = "linuxsogood-topic", group = "sync-group")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println(message.toString());
        }
    }

}
