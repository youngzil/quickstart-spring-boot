/**
 * 项目名称：quickstart-spring-boot-mybatis-generator 
 * 文件名：TestController.java
 * 版本信息：
 * 日期：2018年9月19日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.mybatis.generator.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 * 
 * @author：youngzil@163.com
 * @2018年9月19日 下午1:34:49
 * @since 1.0
 */
@RestController
public class TestController {

    // @Autowired
    // private ClsMapper clsMapper;
    // @Autowired
    // private StudentMapper studentMapper;

    @RequestMapping("test.do")
    public Map<String, Object> test() {

        // Student student = studentMapper.selectByPrimaryKey(1);
        // Cls cls = clsMapper.selectByPrimaryKey(student.getCid());

        Map<String, Object> map = new HashMap<String, Object>();
        // map.put("student", student);
        // map.put("cls", cls);

        return map;
    }
}
