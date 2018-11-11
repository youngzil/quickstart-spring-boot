/**
 * 项目名称：msgframe-core 
 * 文件名：Logger.java
 * 版本信息：
 * 日期：2018年9月10日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Logger
 * 
 * @author：youngzil@163.com
 * @2018年9月10日 下午8:54:17
 * @since 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logger {

    String description() default "";

}
