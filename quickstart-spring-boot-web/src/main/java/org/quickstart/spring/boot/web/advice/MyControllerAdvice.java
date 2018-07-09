/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：ControllerAdvice.java
 * 版本信息：
 * 日期：2017年7月8日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * ControllerAdvice
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月8日 下午4:32:27
 * @version 1.0
 */
@ControllerAdvice(basePackages = "org.quickstart.spring.boot")
public class MyControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    // @ModelAttribute
    // public User newUser() {
    // logger.info("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
    // return new User();
    // }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        logger.info("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String processUnauthenticatedException(NativeWebRequest request, Exception e) {
        logger.info("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");
        return "viewName"; // 返回一个逻辑视图名
    }
}
