/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：ApplicationListenerEnvironmentPrepared.java
 * 版本信息：
 * 日期：2018年1月17日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * ApplicationListenerEnvironmentPrepared
 * 
 * @author：youngzil@163.com
 * @2018年1月17日 下午12:19:37
 * @since 1.0
 */
public class ApplicationListenerEnvironmentPrepared implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println(getClass().getSimpleName());
    }
}

/*用到的事件是ApplicationEnvironmentPreparedEvent，插一句：SpringBoot为ApplicationContextEvent提供了四种事件：
ApplicationStartedEvent ：spring boot启动开始时执行的事件
ApplicationEnvironmentPreparedEvent：spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建。
ApplicationPreparedEvent：spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
ApplicationFailedEvent：spring boot启动异常时执行事件
但是，ApplicationListener的功能不止是止步于此，你可以自定义需要拦截的Event，比如我用到了一个监听事件。*/
