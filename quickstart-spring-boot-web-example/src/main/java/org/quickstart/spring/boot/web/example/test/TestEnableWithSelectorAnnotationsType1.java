/**
 * 项目名称：quickstart-spring-boot-web-example 
 * 文件名：TestEnableWithSelectorAnnotationsType1.java
 * 版本信息：
 * 日期：2018年9月22日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TestEnableWithSelectorAnnotationsType1
 *
 * @author：youngzil@163.com
 * @2018年9月22日 下午11:27:13
 * @since 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestEnableWithSelectorAnnotationsType1 {

    @Autowired
    private String aBean;

    @Test
    public void testInjectedBean() {
        assertThat(aBean, equalTo("Type1"));
    }

    @EnableSomeBeansSelector(criteria = "type1")
    @Configuration
    public static class SpringConfig {
    }
}


@Configuration
class SomeBeanConfigurationType1 {

    @Bean
    public String aBean() {
        return "Type1";
    }

}


@Configuration
class SomeBeanConfigurationDefault {

    @Bean
    public String aBean() {
        return "Default";
    }

}
