package org.quickstart.spring.boot;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.quickstart.spring.boot.web.util.XDateUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class VelocityTest extends BasicTest {

    @Autowired
    VelocityEngine velocityEngine;

    @Test
    public void velocityTest() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", XDateUtils.nowToString());
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");
//        SpringBoot1或Spring4
//        String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "welcome.vm", "UTF-8", model);
//        logger.debug(content);
    }

}
