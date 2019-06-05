/**
 * 项目名称：quickstart-spring-boot-actuator 
 * 文件名：SampleController.java
 * 版本信息：
 * 日期：2017年12月7日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SampleController
 * 
 * @author：youngzil@163.com
 * @2017年12月7日 下午8:31:28
 * @since 1.0
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

}
