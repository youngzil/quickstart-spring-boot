/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：DruidStatViewServlet.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * DruidStatViewServlet 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年11月8日 下午7:03:55 
 * @since 1.0
 */
@WebServlet(urlPatterns="/druid/*",
initParams={
     @WebInitParam(name="allow",value="127.0.0.1,192.168.163.1"),// IP白名单(没有配置或者为空，则允许所有访问)
     @WebInitParam(name="deny",value="192.168.1.73"),// IP黑名单 (存在共同时，deny优先于allow)
     @WebInitParam(name="loginUsername",value="admin"),// 用户名
     @WebInitParam(name="loginPassword",value="123456"),// 密码
     @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
private static final long serialVersionUID = -2688872071445249539L;

}
