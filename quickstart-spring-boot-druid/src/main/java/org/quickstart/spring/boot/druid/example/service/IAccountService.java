/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：IAccountService.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example.service;

import java.util.List;
import org.quickstart.spring.boot.druid.example.model.Account;

/**
 * IAccountService 
 *  
 * @author：youngzil@163.com
 * @2018年11月8日 下午7:07:06 
 * @since 1.0
 */
public interface IAccountService {
    
    int add(Account account);
 
    int update(Account account);
 
    int delete(int id);
 
    Account findAccountById(int id);
 
    List<Account> findAccountList();
    
}
