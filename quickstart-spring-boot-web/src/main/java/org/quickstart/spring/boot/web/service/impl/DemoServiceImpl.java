/**
 * 项目名称：msgframe-console
 * 文件名：DemoService.java
 * 版本信息：
 * 日期：2017年7月5日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.service.impl;

import java.util.List;

import org.quickstart.spring.boot.web.dao.DemoDao;
import org.quickstart.spring.boot.web.entity.DemoUser;
import org.quickstart.spring.boot.web.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoService
 * 
 * @author：yangzl@asiainfo.com
 * @2017年7月5日 下午5:16:35
 * @version 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    /* (non-Javadoc)
     * @see org.quickstart.spring.boot.service.demo.DemoService#getUser(java.lang.String, java.lang.String)
     */
    @Override
    public List<DemoUser> getUser(String name, String age) {
        // TODO Auto-generated method stub
        return demoDao.getUser(name, age);
    }

    /* (non-Javadoc)
     * @see org.quickstart.spring.boot.service.demo.DemoService#getAllUsers()
     */
    @Override
    public List<DemoUser> getAllUsers() {
        // TODO Auto-generated method stub
        return demoDao.getAllUsers();
    }

    /* (non-Javadoc)
     * @see org.quickstart.spring.boot.service.demo.DemoService#addUser(org.quickstart.spring.boot.entity.demo.DemoUser)
     */
    @Override
    public void addUser(DemoUser user) {
        // TODO Auto-generated method stub
        demoDao.addUser(user);

    }

    /* (non-Javadoc)
     * @see org.quickstart.spring.boot.service.demo.DemoService#updateUser(org.quickstart.spring.boot.entity.demo.DemoUser)
     */
    @Override
    public void updateUser(DemoUser user) {
        // TODO Auto-generated method stub
        demoDao.updateUser(user);

    }

    /* (non-Javadoc)
     * @see org.quickstart.spring.boot.service.demo.DemoService#deleteUser(java.lang.String)
     */
    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        demoDao.deleteUser(id);
    }

}
