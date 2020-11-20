/**
 * 项目名称：msgtest-console3
 * 文件名：DemoUser.java
 * 版本信息：
 * 日期：2017年7月5日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * DemoUser
 * 
 * @author：youngzil@163.com
 * @2017年7月5日 下午6:35:22
 * @version 1.0
 */
public class DemoUser {

    private Long id;

    private String name;

    private int age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 存日期时使用
    private Date beginTimestamp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBeginTimestamp() {
        return beginTimestamp;
    }

    public void setBeginTimestamp(Date beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

}
