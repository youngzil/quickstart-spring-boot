/**
 * 项目名称：msgframe-console3 
 * 文件名：UserControllerTest.java
 * 版本信息：
 * 日期：2017年7月6日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quickstart.spring.boot.web.entity.DemoUser;
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
 * @author：yangzl@asiainfo.com
 * @2017年7月6日 下午3:01:02
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class DemoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllUsers() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/user/getAllUsers", String.class);
        System.out.println(entity.getBody());
    }

    @Test
    public void testGetUser() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/user/getUser?name=yangzl&age=23", String.class);
        System.out.println(entity.getBody());
    }

    @Test
    public void testAddUser() throws Exception {
        DemoUser user = new DemoUser();
        user.setId(1L);
        user.setName("yangzl");
        user.setAge(23);
        ResponseEntity<String> entity = this.restTemplate.postForEntity("/user/addUser", user, String.class);
        System.out.println(entity.getBody());
    }

    @Test
    public void testUpdateUser() throws Exception {
        DemoUser user = new DemoUser();
        user.setId(1L);
        user.setName("yangzl");
        user.setAge(24);
        ResponseEntity<String> entity = this.restTemplate.postForEntity("/user/updateUser", user, String.class);
        System.out.println(entity.getBody());
    }

    @Test
    public void testDeleteUser() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.postForEntity("/user/deleteUser?id=1", "", String.class);
        System.out.println(entity.getBody());
    }

}
