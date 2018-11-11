/**
 * 项目名称：msgframe-console3 
 * 文件名：DemoController.java
 * 版本信息：
 * 日期：2017年7月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.controller;

import java.util.List;

import org.quickstart.spring.boot.web.entity.DemoUser;
import org.quickstart.spring.boot.web.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DemoController
 * 
 * @author：youngzil@163.com
 * @2017年7月5日 下午5:18:52
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class DemoController {

    @Autowired
    private DemoService demoService;

    // @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @GetMapping("/getUser")
    @ResponseBody
    public List<DemoUser> queryUser(@RequestParam(required = false) String userCode, // 1
            @RequestParam(required = false) String userName) {// 2
        return demoService.getUser(userCode, userName);
    }

    @RequestMapping(value = "/getAllUsers")
    @ResponseBody
    public List<DemoUser> getAllUsers() {
        return demoService.getAllUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody DemoUser user) {
        demoService.addUser(user);
    }

    // @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @PostMapping("/updateUser")
    @ResponseBody
    public void updateUser(@RequestBody DemoUser user) {
        demoService.updateUser(user);
    }

    // @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @PostMapping(value = "/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam String id) {
        demoService.deleteUser(id);
    }

}
