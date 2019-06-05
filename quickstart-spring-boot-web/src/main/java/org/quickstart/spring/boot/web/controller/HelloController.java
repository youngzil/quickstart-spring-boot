/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：HelloController.java
 * 版本信息：
 * 日期：2017年7月8日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HelloController
 * 
 * @author：youngzil@163.com
 * @2017年7月8日 下午4:24:33
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/sayHello")
    @ResponseBody
    public String sayHello() {// 1
        return "Hello World";
    }

    @GetMapping(value = "/sayHelloException")
    @ResponseBody
    public String sayHelloException() throws Exception {// 1
        throw new Exception();
    }

}
