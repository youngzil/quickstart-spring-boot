/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：HelloController.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example.controller;

import java.util.List;

import org.quickstart.spring.boot.druid.example.model.Account;
import org.quickstart.spring.boot.druid.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * 
 * @author：yangzl@asiainfo.com
 * @2018年11月8日 下午7:24:27
 * @since 1.0
 */
@RestController
public class HelloController {
    @Autowired
    // 使用@Qualifier来提示Spring该用什么类型的数据填充该变量IoC
    @Qualifier("accountService")
    private IAccountService accService;

    @RequestMapping("/accService")
    public List<Account> getAccounts() {
        return accService.findAccountList();
    }

}
