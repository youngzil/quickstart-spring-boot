/**
 * 项目名称：msgframe-console3 
 * 文件名：UserControllerTest.java
 * 版本信息：
 * 日期：2017年7月6日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quickstart.spring.boot.web.config.MyProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
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
public class PropsLoadTest extends BasicTest {

    @Autowired
    private MyProps myProps;

    @Test
    public void propsTest() throws JsonProcessingException {
        System.out.println("simpleProp: " + myProps.getSimpleProp());
        System.out.println("arrayProps: " + objectMapper.writeValueAsString(myProps.getArrayProps()));
        System.out.println("listProp1: " + objectMapper.writeValueAsString(myProps.getListProp1()));
        System.out.println("listProp2: " + objectMapper.writeValueAsString(myProps.getListProp2()));
        System.out.println("mapProps: " + objectMapper.writeValueAsString(myProps.getMapProps()));
    }

}
