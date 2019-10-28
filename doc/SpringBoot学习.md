1、Springboot的条件注解
2、使用@ComponentScan注解用来扫描加排除
3、spring启动执行某些特定方法
4、SpringBoot使用spring-boot-maven-plugin插件打包，实际是通过org.springframework.boot.loader.JarLauncher来加载jar的









---------------------------------------------------------------------------------------------------------------------
https://blog.csdn.net/qq_36722039/article/details/81572399

可以使用@ComponentScan注解用来扫描加排除，不加ComponentScan注解，springboot是默认扫描springboot启动类所在的包及其子包，我们现在自己扫描，然后使用@ComponentScan注解的excludeFilters属性用来排除不想扫描的bean


---------------------------------------------------------------------------------------------------------------------
spring启动执行某些特定方法：
Springboot给我们提供了两种“开机启动”某些方法的方式：ApplicationRunner和CommandLineRunner。
Spring的配置文件的init-method
继承某些接口方法，实例化的时候，会执行某些特定方法

---------------------------------------------------------------------------------------------------------------------




SpringBoot使用spring-boot-maven-plugin插件打包，实际是通过org.springframework.boot.loader.JarLauncher来加载jar的

<build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.6.0</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
  
  

Manifest-Version: 1.0
Implementation-Title: AIFGateway/Security/Client
Implementation-Version: 1.0
Start-Class: com.pobo.spring.security.demo.Application
Spring-Boot-Classes: BOOT-INF/classes/
Spring-Boot-Lib: BOOT-INF/lib/
Build-Jdk-Spec: 1.8
Spring-Boot-Version: 2.1.6.RELEASE
Created-By: Maven Archiver 3.4.0
Main-Class: org.springframework.boot.loader.JarLauncher




---------------------------------------------------------------------------------------------------------------------





---------------------------------------------------------------------------------------------------------------------




---------------------------------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------------------------------




---------------------------------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------------------------------






---------------------------------------------------------------------------------------------------------------------





---------------------------------------------------------------------------------------------------------------------




---------------------------------------------------------------------------------------------------------------------



---------------------------------------------------------------------------------------------------------------------




