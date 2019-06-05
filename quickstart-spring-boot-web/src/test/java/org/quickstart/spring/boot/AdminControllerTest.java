/**
 * 项目名称：msgframe-console3 
 * 文件名：UserControllerTest.java
 * 版本信息：
 * 日期：2017年7月6日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
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
public class AdminControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(AdminControllerTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAdminLogin() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/api/admin/login?userName=admin&password=pword", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        logger.debug(entity.getBody());
    }

}
