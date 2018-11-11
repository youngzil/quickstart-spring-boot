/**
 * 项目名称：quickstart-spring-boot-kafka 
 * 文件名：KafkaConsumerTest.java
 * 版本信息：
 * 日期：2017年11月10日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.kafka.example3;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * KafkaConsumerTest
 * 
 * @author：youngzil@163.com
 * @2017年11月10日 下午2:04:11
 * @since 1.0
 */
public class KafkaConsumerTest implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> record) {
        System.out.println(record);
    }

}
