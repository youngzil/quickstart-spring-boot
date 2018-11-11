/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：ScheduleTaskSample.java
 * 版本信息：
 * 日期：2017年8月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.quartz.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * ScheduleTaskSample
 * 
 * @author：youngzil@163.com
 * @2017年8月5日 下午4:30:50
 * @version 2.0
 */
@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTaskSample {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskSample.class);

    public void sayHello() {
        logger.info("Hello world, i'm the king of the world!!!");
    }
}
