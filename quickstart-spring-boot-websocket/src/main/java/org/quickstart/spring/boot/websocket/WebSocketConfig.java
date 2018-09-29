package org.quickstart.spring.boot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by sang on 16-12-22.
 */
@Configuration
@EnableWebSocketMessageBroker
// 通过EnableWebSocketMessageBroker 开启使用STOMP协议来传输基于代理(message broker)的消息,此时浏览器支持使用@MessageMapping 就像支持@RequestMapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /***
     * 注册 Stomp的端点 addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址 withSockJS：使用SockJS协议
     * 
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 允许使用socketJs方式访问，访问点为webSocketServer，允许跨域
        // 在网页上我们就可以通过这个链接
        // http://localhost:8080/webSocketServer
        // 来和服务器的WebSocket连接
        // 注册一个名字为"gs-guide-websocket" 的endpoint,并指定 SockJS协议;添加一个服务端点，来接收客户端的连接
        // 设置端点，客户端通过http://localhost:8080/endpointSang来和服务器进行websocket连接
        stompEndpointRegistry.addEndpoint("/endpointSang")//
                .setAllowedOrigins("*")// 添加允许跨域访问
                .withSockJS();
    }

    /**
     * 配置消息代理 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 订阅Broker名称
        // 用户订阅主题的前缀
        // /topic 代表发布广播，即群发
        // /queue 代表点对点，即发指定用户
        // registry.enableSimpleBroker("/queue", "/topic");

        // 配置消息代理(message broker) 设置消息连接请求的各种规范
        registry.enableSimpleBroker("/topic");// 推送消息前缀,客户端订阅地址的前缀信息
        // 全局使用的消息前缀（客户端订阅路径上会体现出来）
        // 设置客户端请求前缀
        // 例如客户端发送消息的目的地为/app/sendTest，则对应控制层@MessageMapping(“/sendTest”)
        // 客户端订阅主题的目的地为/app/subscribeTest，则对应控制层@SubscribeMapping(“/subscribeTest”)

        // registry.setApplicationDestinationPrefixes("/api/v1/socket/req");//应用请求前缀,客户端给服务端发消息的地址的前缀
        // 点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        // registry.setUserDestinationPrefix("/user");//推送用户前缀,
    }

}
