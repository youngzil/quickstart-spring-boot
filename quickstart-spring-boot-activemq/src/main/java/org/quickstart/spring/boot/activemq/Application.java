/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：App.java
 * 版本信息：
 * 日期：2017年5月7日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * App
 * 
 * @author：youngzil@163.com
 * @2017年5月7日 下午12:14:46
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    // http://localhost:8081/hello/sayHello

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        logger.info("My Spring Boot Application Started");
    }

}
