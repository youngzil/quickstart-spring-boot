/**
 * 项目名称：quickstart-spring-boot-kafka 
 * 文件名：KafkaConsumerConfig.java
 * 版本信息：
 * 日期：2017年11月10日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.kafka.example2;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

/**
 * KafkaConsumerConfig
 * 
 * @author：youngzil@163.com
 * @2017年11月10日 下午12:12:10
 * @since 1.0
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${kafka.broker.address}")
    private String brokerAddress;

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, "firehome-group");
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return propsMap;
    }

    /**
     * 监听,监听里面,写的就是业务逻辑了,从kafka里面得到数据后,具体怎么去处理. 如果需要开启kafka处理消息的广播模式,多个监听要监听不同的group,即方法上的注解@KafkaListener里的group一定要不一样.如果多个监听里的group写的一样,就会造成只有一个监听能处理其中的消息,另外监听就不能处理消息了.也即是kafka的分布式消息处理方式.
     * 在同一个group里的监听,共同处理接收到的消息,会根据一定的算法来处理.如果不在一个组,但是监听的是同一个topic的话,就会形成广播模式 listener
     * 
     * @Description:
     * @return Listener
     * @Exception
     * @author：youngzil@163.com
     * @2017年11月10日 下午12:20:41
     * @since 1.0
     */
    @Bean
    public Listener listener() {
        return new Listener();
    }
}
