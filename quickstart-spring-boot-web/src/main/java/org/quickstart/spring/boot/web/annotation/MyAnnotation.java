/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：MyAnnotation.java
 * 版本信息：
 * 日期：2017年7月8日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MyAnnotation
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月8日 下午5:02:54
 * @version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    long timeoutMillis() default 0;

}
