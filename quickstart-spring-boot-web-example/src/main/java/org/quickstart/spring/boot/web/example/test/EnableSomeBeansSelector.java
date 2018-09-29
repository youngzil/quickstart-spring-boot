/**
 * 项目名称：quickstart-spring-boot-web-example 
 * 文件名：EnableSomeBeansSelector.java
 * 版本信息：
 * 日期：2018年9月22日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.example.test;

/**
 * EnableSomeBeansSelector 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年9月22日 下午11:26:01 
 * @since 1.0
 */
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(SomeBeanConfigurationSelector.class)
public @interface EnableSomeBeansSelector {
    String criteria() default "default";
}
