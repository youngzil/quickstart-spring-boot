package org.quickstart.spring.boot.websocket;

import javax.annotation.Resource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sang on 16-12-22.
 */
@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }

    // 接收客户端发送的消息，当客户端发送消息的目的地为/app/sendTest时，交给该注解所在的方法处理消息，其中/app是在
    // registry.setApplicationDestinationPrefixes("/app");一步配置的客户端请求前缀
    // 若没有添加@SendTo注解且该方法有返回值，则返回的目的地地址为/topic/sendTest，经过消息代理，客户端需要订阅了这个主题才能收到返回消息
    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public ResponseMessage sendDemo(RequestMessage message) {
        System.out.println("接收到了信息" + message.getName());
        return new ResponseMessage("你发送的消息为:" + message.getName());
    }

    /*说明： 
    1. @MessageMapping注解不是@RequestMapping，后者是我们熟悉的用于http请求的映射，前者是基于webSocket协议的请求。但是理解都很简单。 
    2.  SimpMessagingTemplate 
    SimpMessagingTemplate是Spring-WebSocket内置(就是封装起来的和SDR差不多，很方便)的一个消息发送工具，可以将消息发送到指定的客户端。 
    3. @SendTo这个注解就是将信息分发到订阅者 ，和messagingTemplate.convertAndSend()等价。*/

    /*@MessageMapping("/message")
    //@SendTo("/topic/greetings")
    //接收/app/message发来的value，然后将value转发到/topic/greetings客户端
    public Greeting message(String message) throws Exception{
        //通过convertAndSendToUser 向用户发送信息,
        // 第一个参数是接收消息的用户,第二个参数是浏览器订阅的地址,第三个参数是消息本身
        //messagingTemplate.convertAndSendToUser();
        messagingTemplate.convertAndSend("/topic/greetings",new Greeting(message));
        return null;
    }*/

    // 接收客户端发送的订阅，当客户端订阅的目的地为/app/subscribeTest时，交给该注解所在的方法处理订阅，其中/app为客户端请求前缀
    // 若没有添加@SendTo注解且该方法有返回值，则返回的目的地地址为/app/sendTest，不经过消息代理，客户端需要订阅了这个主题才能收到返回消息
    // @SendTo(“/topic/subscribeTest”)
    // 修改返回消息的目的地地址为/topic/subscribeTest，经过消息代理，客户端需要订阅了这个主题才能收到返回消息
    @SubscribeMapping("/subscribeTest")
    public ResponseMessage sub() {
        System.out.println("XXX用户订阅了我。。。");
        return new ResponseMessage("感谢你订阅了我。。。");
    }

    /*服务器主动推数据
    任意类中都可以
    public class 任意类{
        @Autowired
        private SimpMessagingTemplate messagingTemplate;
    
        //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
        public void templateTest() {
            messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));
        }
    }*/

    // 第二种
    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @MessageMapping("/welcome2")
    public ResponseMessage toTopic(RequestMessage msg) throws Exception {
        System.out.println("======================" + msg.getName());
        this.messagingTemplate.convertAndSend("/api/v1/socket/send", msg.getName());
        return new ResponseMessage("欢迎使用webScoket：" + msg.getName());
    }

    @MessageMapping("/message")
    public ResponseMessage toUser(RequestMessage msg) {
        System.out.println(msg.getName());
        this.messagingTemplate.convertAndSendToUser("123", "/message", msg.getName());
        return new ResponseMessage("欢迎使用webScoket：" + msg.getName());
    }

}
