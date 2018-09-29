使用websocket有两种方式：1是使用sockjs，2是使用h5的标准。使用Html5标准自然更方便简单，所以记录的是配合h5的使用方法。



SockJS是一个JavaScript库，提供跨浏览器JavaScript的API，创建了一个低延迟、全双工的浏览器和web服务器之间通信通道。
服务端：sockjs-node（https://github.com/sockjs/sockjs-node）
客户端：sockjs-clien（https://github.com/sockjs/sockjs-client）
node-static（https://www.npmjs.com/package/node-static）是Node.js兼容HTTP静态文件服务器处理模块，提供内置的缓存支持。


SockJS：
SockJS 是一个浏览器上运行的 JavaScript 库，如果浏览器不支持 WebSocket，该库可以模拟对 WebSocket 的支持，实现浏览器和 Web 服务器之间低延迟、全双工、跨域的通讯通道。
Stomp
Stomp 提供了客户端和代理之间进行广泛消息传输的框架。Stomp 是一个非常简单而且易用的通讯协议实现，尽管代理端的编写可能非常复杂，但是编写一个 Stomp 客户端却是很简单的事情，另外你可以使用 Telnet 来与你的 Stomp 代理进行交互。



参考
https://blog.csdn.net/ligang2585116/article/details/47277917
https://www.cnblogs.com/betterboyz/p/8669879.html
https://blog.csdn.net/qq_28988969/article/details/78113463
https://spring.io/guides/gs/messaging-stomp-websocket/
https://blog.csdn.net/tengxing007/article/details/77961355
