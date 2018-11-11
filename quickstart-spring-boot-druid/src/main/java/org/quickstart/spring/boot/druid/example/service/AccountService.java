/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：AccountService.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example.service;

import java.util.List;

import org.quickstart.spring.boot.druid.example.dao.IAccountDAO;
import org.quickstart.spring.boot.druid.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * AccountService 
 *  
 * @author：youngzil@163.com
 * @2018年11月8日 下午7:15:14 
 * @since 1.0
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    @Qualifier("accountDaoImpl")
    private IAccountDAO accDaoImpl;
    @Override
    public int add(Account account) {
        return accDaoImpl.add(account);
    }
 
    @Override
    public int update(Account account) {
        return accDaoImpl.update(account);
    }
 
    @Override
    public int delete(int id) {
        return accDaoImpl.delete(id);
    }
 
    @Override
    public Account findAccountById(int id) {
        return accDaoImpl.findAccountById(id);
    }
 
    @Override
    public List<Account> findAccountList() {
        return accDaoImpl.findAccountList();
    }
}

