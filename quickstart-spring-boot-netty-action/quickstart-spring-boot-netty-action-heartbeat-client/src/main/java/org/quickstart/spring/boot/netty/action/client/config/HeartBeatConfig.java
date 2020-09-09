package org.quickstart.spring.boot.netty.action.client.config;

import org.quickstart.spring.boot.netty.action.common.pojo.CustomProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Function:构建心跳使用的 bean
 *
 * @author crossoverJie
 *         Date: 24/05/2018 15:55
 * @since JDK 1.8
 */
@Configuration
public class HeartBeatConfig {

    @Value("${channel.id}")
    private long id ;


    @Bean(value = "heartBeat")
    public CustomProtocol heartBeat(){
        return new CustomProtocol(id,"ping") ;
    }
}
