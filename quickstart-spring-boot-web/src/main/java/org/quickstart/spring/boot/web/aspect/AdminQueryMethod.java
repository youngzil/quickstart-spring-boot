/**
 * 项目名称：msgframe-console4 
 * 文件名：AdminQueryMethod.java
 * 版本信息：
 * 日期：2017年8月2日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * AdminQueryMethod
 * 
 * @author：yangzl@asiainfo.com
 * @2017年8月2日 下午3:21:51
 * @version 2.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminQueryMethod {

    // Class<? extends PageRequest>[] value() default {};

}
