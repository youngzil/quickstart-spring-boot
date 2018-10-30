Springboot给我们提供了两种“开机启动”某些方法的方式：ApplicationRunner和CommandLineRunner。
源码在run方法中afterRefresh会取出所有的ApplicationRunner和CommandLineRunner的bean来执行，从代码来看，ApplicationRunner使用的入参是ApplicationArguments，CommandLineRunner使用的入参是args.getSourceArgs()，也就是命令行传来的参数，所以这两种开机启动只是入参不同，其他都是一样的。


SpringBoot中的绝大多数的bean都是在run方法中的refreshContext(context)中初始化并保存的。


SpringBoot提供了SpringApplicationRunListener接口，来在ApplicationContetext初始化各个阶段来扩展



说到 Java 微服务，不得不提及 Spring Boot，它已经变得非常流行。Spring Boot 和 Spring 也是基于 Java，是 Jakarta EE 的竞争对手。Spring Boot 采用了 Dropwizard 和 Pivotal 的“fat jar”概念。Pivotal 是 Spring Boot 背后的公司，正在推动“云原生”一词，这个词最初是由 Netflix 发明的，目前已经在市场上得到广泛使用。



SpringBoot属性配置、读取等
https://www.cnblogs.com/shamo89/p/8178109.html




