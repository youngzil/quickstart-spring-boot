/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：ApplicationStartListenerConfig.java
 * 版本信息：
 * 日期：2018年1月17日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ApplicationStartListenerConfig 实例化ApplicationStartListener这个类，在Spring boot中通过一个配置类来进行实例化
 * 
 * @author：youngzil@163.com
 * @2018年1月17日 上午11:19:20
 * @since 1.0
 */
@Configuration
public class ApplicationStartListenerConfig {

    @Bean
    public ApplicationStartListener applicationStartListener() {
        return new ApplicationStartListener();
    }
}
