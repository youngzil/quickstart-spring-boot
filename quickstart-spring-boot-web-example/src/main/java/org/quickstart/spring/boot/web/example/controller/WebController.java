package org.quickstart.spring.boot.web.example.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/hi")
    public String hi(Map<String, Object> model) {
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");
        return "welcome"; // 自动寻找resources/templates中名字为welcome.ftl/welcome.vm的文件作为模板，拼装后返回
    }

    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // dateFormat.setLenient(false);
    // binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); //true:允许输入空值，false:不能
    // }

    // @InitBinder
    // protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // simpleDateFormat.setLenient(false);
    // CustomDateEditor dateEditor = new CustomDateEditor(simpleDateFormat, true);
    // binder.registerCustomEditor(Date.class,dateEditor);
    // }

}
