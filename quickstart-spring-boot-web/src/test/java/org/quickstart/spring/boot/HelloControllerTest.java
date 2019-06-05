/**
 * 项目名称：msgframe-console3 
 * 文件名：UserControllerTest.java
 * 版本信息：
 * 日期：2017年7月6日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserControllerTest
 * 
 * @author：youngzil@163.com
 * @2017年7月6日 下午3:01:02
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSayHello() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/hello/sayHello", String.class);
        System.out.println(entity.getBody());
    }

    @Test
    public void testSayHelloException() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/hello/sayHelloException", String.class);
        System.out.println(entity.getBody());
    }

}
