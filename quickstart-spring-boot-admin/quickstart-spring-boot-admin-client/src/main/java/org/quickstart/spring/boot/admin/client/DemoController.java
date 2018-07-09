package org.quickstart.spring.boot.admin.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by patterncat on 2016/4/1.
 */
@RestController
@RequestMapping("")
public class DemoController {

    @RequestMapping("/demo")
    public String home() {
        return "hello";
    }
}
