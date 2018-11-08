/**
 * 项目名称：rocketmq-console-ng 
 * 文件名：SpringBootStartApplication.java
 * 版本信息：
 * 日期：2018年10月17日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * SpringBootStartApplication 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年10月17日 下午11:00:24 
 * @since 1.0
 */
/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
@SpringBootApplication
public class SpringBootStartApplication extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(App.class);
    }
}
