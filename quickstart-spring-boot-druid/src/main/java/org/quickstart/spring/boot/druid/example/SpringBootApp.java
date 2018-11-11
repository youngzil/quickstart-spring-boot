/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：SpringBootApp.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * SpringBootApp 
 *  
 * @author：youngzil@163.com
 * @2018年11月8日 下午7:04:45 
 * @since 1.0
 */

//返回json字符串的数据，直接可以编写RESTFul的接口
@RestController

//@SpringBootApplication声明让spring boot自动给程序进行必要的配置
@SpringBootApplication

//添加servlet组件扫描，使得Spring能够扫描到我们编写的servlet和filter
@ServletComponentScan(basePackages="org.quickstart.spring.boot.druid.example")
public class SpringBootApp {

 public static void main(String[] args) {
     SpringApplication.run(SpringBootApp.class, args);
 }
}
