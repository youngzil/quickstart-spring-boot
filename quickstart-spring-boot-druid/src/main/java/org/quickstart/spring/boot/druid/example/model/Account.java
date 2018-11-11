/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：Account.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Account
 * 
 * @author：youngzil@163.com
 * @2018年11月8日 下午7:27:13
 * @since 1.0
 */
@Getter
@Setter
public class Account {

    private int id;
    private String name;
    private float money;

}
