/**
 * 项目名称：msgframe-console
 * 文件名：DemoService.java
 * 版本信息：
 * 日期：2017年7月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.service;

import java.util.List;

import org.quickstart.spring.boot.web.entity.DemoUser;

/**
 * DemoService
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月5日 下午5:16:35
 * @version 1.0
 */
public interface DemoService {

    List<DemoUser> getUser(String name, String age);

    List<DemoUser> getAllUsers();

    void addUser(DemoUser user);

    void updateUser(DemoUser user);

    void deleteUser(String id);

}
