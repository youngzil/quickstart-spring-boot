/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：ApplicationStartListener.java
 * 版本信息：
 * 日期：2018年1月17日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * ApplicationStartListener 在一些业务场景中，当容器初始化完成之后，需要处理一些操作，比如一些数据的加载、初始化缓存、特定任务的注册等等。这个时候我们就可以使用Spring提供的ApplicationListener来进行操作。
 * 
 * @author：youngzil@163.com
 * @2018年1月17日 上午11:16:11
 * @since 1.0
 */
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {
    // 本文以在Spring boot下的使用为例来进行说明。首先，需要实现ApplicationListener接口并实现onApplicationEvent方法。把需要处理的操作放在onApplicationEvent中进行处理：
    // ApplicationStartListener的onApplicationEvent方法在容器启动时已经被成功调用了。而此时初始化的容器为root容器。

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        // 二次调用问题
        // 此处使用Spring boot来进行操作，没有出现二次调用的问题。在使用传统的application.xml和project-servlet.xml配置中会出现二次调用的问题。主要原因是初始化root容器之后，会初始化project-servlet.xml对应的子容器。我们需要的是只执行一遍即可。那么上面打印父容器的代码用来进行判断排除子容器即可。在业务处理之前添加如下判断：
        // 这样其他容器的初始化就会直接返回，而父容器（Parent为null的容器）启动时将会执行相应的业务操作。
        if (contextRefreshedEvent.getApplicationContext().getParent() != null) {
            return;
        }

        System.out.println("我的父容器为：" + contextRefreshedEvent.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了。");
    }

    // 在spring中InitializingBean接口也提供了类似的功能，只不过它进行操作的时机是在所有bean都被实例化之后才进行调用。根据不同的业务场景和需求，可选择不同的方案来实现。

}
