package org.quickstart.spring.boot;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

public class FreeMarkerTest extends BasicTest {

    @Autowired
    Configuration configuration; // freeMarker configuration

    @Test
    public void testHtmlUsingFreeMarker() throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", new Date());
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");

        Template t = configuration.getTemplate("welcome.ftl"); // freeMarker
                                                               // template
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        logger.debug(content);
    }

}
