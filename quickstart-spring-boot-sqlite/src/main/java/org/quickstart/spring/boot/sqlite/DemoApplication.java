package org.quickstart.spring.boot.sqlite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 下面这一行为新增数据库关联注解
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("org.quickstart.spring.boot.sqlite")
public class DemoApplication {

    // 先运行测试类Sample.java

    // http://localhost:8080
    // http://localhost:8080/list

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
