/**
 * 项目名称：quickstart-spring-boot-kafka 
 * 文件名：KafkaProducerTest.java
 * 版本信息：
 * 日期：2017年11月10日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.kafka.example3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * KafkaProducerTest kafka读写测试类
 * 
 * @author：yangzl@asiainfo.com
 * @2017年11月10日 下午1:59:23
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kafka-producer.xml"})
public class KafkaProducerTest {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    /**
     * 向kafka里写数据.<br/>
     * 
     * @author miaohongbin Date:2016年6月24日下午6:22:58
     */
    @Test
    public void testTemplateSend() {
        kafkaTemplate.sendDefault("haha111");
    }

}
