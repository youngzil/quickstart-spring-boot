/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：ApplicationTest.java
 * 版本信息：
 * 日期：2018年1月17日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.listener;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * ApplicationTest
 * 
 * @author：youngzil@163.com
 * @2018年1月17日 下午12:21:32
 * @since 1.0
 */
@SpringBootApplication
public class ApplicationTest {
    // ApplicationListener使用
    // 方案一：在启动类中配置
    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(applicationClass);
        app.addListeners(new StompConnectEvent()); // 加入监听事件
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<ApplicationTest> applicationClass = ApplicationTest.class;

    // 方案二：在application.properties中配置（多个用逗号隔开）
    // context.listener.classes=com.StompConnectEvent

    // 方案三：@Configuration
    // 说了这么多，其实就是否决了上面两种启动方案（也不能说否决，只能说使用上面两种方案，有一些需求达不到），我的解决方案就是，在定义好ApplicationListener之后，在类前面加上@Configuration，如果不知道@Configuration是啥的自行百度哈~
    // @Configuration
    // public class StompConnectEvent implements ……

    // 方案一和二不好
    // 它会在项目最开始的时候启动（在banner前我一开始楞是没找到），这样在最前面启动，会有什么副作用呢？你试试看在你的Event中使用@Autowired注入一个bean。为什么要注入？总有业务场景需要你在监听事件后做一些事情。注入后你会发现报错 java.lang.NullPointerException: null
    // 加上前面的启动时间和和这个错误的类型，我们不难发现，是因为在启动这个监听器的时候，相应的BeanFactory还没加载。换句话说，启动的太早了！

    // 方案三@Autowired注入不报错

}
