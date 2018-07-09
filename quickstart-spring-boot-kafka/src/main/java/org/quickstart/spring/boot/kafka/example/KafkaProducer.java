/**
 * 项目名称：quickstart-spring-boot-kafka 
 * 文件名：KafkaProducer.java
 * 版本信息：
 * 日期：2017年11月9日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.kafka.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * KafkaProducer
 * 
 * 依赖： <dependency> <groupId>org.springframework.kafka</groupId> <artifactId>spring-kafka</artifactId> <version>1.0.5.RELEASE</version> </dependency>
 * 
 * 使用案例：
 * 
 * @Resource private KafkaTemplate kafkaTemplate;
 * 
 *           调用方法发送数据： kafkaTemplate.send(topic, msg);
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月9日 下午10:37:03
 * @since 1.0
 */
@Configuration
@EnableKafka
public class KafkaProducer {

    /**
     * 
     * Description：获取配置 Date： 2017年7月11日
     * 
     * @author shaqf
     */
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        // kafka.metadata.broker.list=10.16.0.214:9092,10.16.0.215:9092,10.16.0.216:9092
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 4096);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    /** 获取工厂 */
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /** 注册实例 */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
