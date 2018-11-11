/**
 * 项目名称：quickstart-spring-boot-web 
 * 文件名：StompConnectEvent.java
 * 版本信息：
 * 日期：2018年1月17日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * StompConnectEvent
 * 
 * @author：youngzil@163.com
 * @2018年1月17日 下午12:23:43
 * @since 1.0
 */
public class StompConnectEvent implements ApplicationListener<ContextRefreshedEvent> {

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // TODO Auto-generated method stub

    }

}
