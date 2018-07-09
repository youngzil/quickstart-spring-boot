Spring Boot框架提供帮助监控和管理应用，只需2个步骤：
1. 在项目的pom.xml配置依赖：
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
2. 启动项目，即可通过以下URL监控相关信息，如：
http://localhost:8080/health  查看应用健康指标
http://localhost:8080/beans  查看所有Spring Beans的完整列表
http://localhost:8080/metrics 查看应用基本指标

http://localhost:8080/info

/env、/info、/metrics、/health等


/env提供应用程序的环境变量，如果你在调试时想知道某个配置项在运行时的值，可以通过这个endpoint访问——访问http://localhost:8080/env，可以看到很多方面的配置，例如，class path resources—[tomcat.https.properties]、applicationConfig—[classpath:/application.properties]、commonsConfig、systemEnvironment、systemProperties等。

/configprops提供不同配置对象，例如WebConfiguration.TomcatSslConnectionProperties，它与/env不同的地方在于它会表示出与配置项绑定的对象。尝试下访问http://localhost:8080/configprops，然后在网页中查询custom.tomcat.https，可以看到我们之前用于配置TomcatSslConnector对象的属性值(参见：让你的Spring Boot工程支持HTTP和HTTPS)。

/autoconfig以web形式对外暴露AutoConfiguration 信息，这些信息的解释可以参考Spring Boot：定制自己的starter一文，这样我们就不需要通过“修改应用程序的日志级别和查看应用的启动信息”来查看应用的自动配置情况了。

/beans，这个endpoint列出所有由Spring Boot创建的bean。

/mapping，这个endpoint显示当前应用支持的URL映射，该映射关系由HandlerMapping类维护，通过这个endpoint可以查询某个URL的路由信息。

/info，这个endpoint显示应用程序的基本描述，在之前的实践例子中我们看过它的返回信息，属性值来自appliaction.properties，同时也可以使用占位符获取pom.xml文件中的信息。任何以info.开头的属性都会在访问http://localhost:8080/info时显示。
/health提供应用程序的健康状态，或者是某个核心模块的健康状态。
/metrics，这个endpoint显示Metrics 子系统管理的信息，后面的文章会详细介绍它。

http://www.jianshu.com/p/734519d3c383

http://www.jianshu.com/p/673385926ce1



