/**
 * 项目名称：ddmp-test 
 * 文件名：MqttConfig.java
 * 版本信息：
 * 日期：2017年10月12日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.temp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MqttConfig
 * 
 * @author：youngzil@163.com
 * @2017年10月12日 上午10:29:57
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = "mqtt.client")
public class MqttConfig {

    private int coreThreadSize = 20;

    private int maxThreadSize = 1000;

    private int onlineNums = 20;

    public int getCoreThreadSize() {
        return coreThreadSize;
    }

    public void setCoreThreadSize(int coreThreadSize) {
        this.coreThreadSize = coreThreadSize;
    }

    public int getMaxThreadSize() {
        return maxThreadSize;
    }

    public void setMaxThreadSize(int maxThreadSize) {
        this.maxThreadSize = maxThreadSize;
    }

    public int getOnlineNums() {
        return onlineNums;
    }

    public void setOnlineNums(int onlineNums) {
        this.onlineNums = onlineNums;
    }

}
