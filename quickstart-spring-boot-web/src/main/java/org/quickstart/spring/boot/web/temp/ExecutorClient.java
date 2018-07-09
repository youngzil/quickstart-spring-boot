/**
 * 项目名称：ddmp-test 
 * 文件名：ExecutorClient.java
 * 版本信息：
 * 日期：2017年10月12日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.temp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * ExecutorClient
 * 
 * @author：yangzl@asiainfo.com
 * @2017年10月12日 上午11:05:55
 * @since 1.0
 */
@Component
public class ExecutorClient implements CommandLineRunner {

    @Autowired
    private MqttConfig mqttConfig;

    private ThreadPoolExecutor mqttClientExecutor;

    private BlockingQueue<Runnable> clientQueue;

    /* (non-Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {

        // IpuUtility.error("启动出错");

        this.validateMqttClientConfig(mqttConfig);

        this.clientQueue = new LinkedBlockingQueue<Runnable>(1000);

        this.mqttClientExecutor = new ThreadPoolExecutor(//
                this.mqttConfig.getOnlineNums(), //
                this.mqttConfig.getOnlineNums(), //
                1000 * 30, //
                TimeUnit.MILLISECONDS, //
                this.clientQueue, //
                new ThreadFactoryImpl("mqtt_client_id_"));

        while (true) {
            mqttClientExecutor.submit(new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub

                }
            }));
        }

    }

    private void validateMqttClientConfig(MqttConfig mqttConfig) throws Exception {

        if (mqttConfig.getOnlineNums() <= 0) {
            throw new RuntimeException("线程数量必须大于0");
        }

    }

}
