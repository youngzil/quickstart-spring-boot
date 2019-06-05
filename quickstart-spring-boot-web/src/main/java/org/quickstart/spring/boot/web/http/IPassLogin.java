/**
 * 项目名称：msgframe-core 
 * 文件名：IPassLogin.java
 * 版本信息：
 * 日期：2018年7月10日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.http;

/**
 * IPassLogin
 * 
 * @author：youngzil@163.com
 * @2018年7月10日 下午3:54:52
 * @since 1.0
 */
public class IPassLogin {

    private String apps;

    private String user;

    private String role;

    private String key;

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "IPassLogin [apps=" + apps + ", user=" + user + ", role=" + role + ", key=" + key + "]";
    }

}
