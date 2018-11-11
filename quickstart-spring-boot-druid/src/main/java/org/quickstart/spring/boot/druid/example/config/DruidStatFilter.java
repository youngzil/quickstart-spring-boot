/**
 * 项目名称：quickstart-spring-boot-druid 
 * 文件名：DruidStatFilter.java
 * 版本信息：
 * 日期：2018年11月8日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.druid.example.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * DruidStatFilter 
 *  
 * @author：youngzil@163.com
 * @2018年11月8日 下午7:02:59 
 * @since 1.0
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
    @WebInitParam(name=WebStatFilter.PARAM_NAME_EXCLUSIONS,value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
}
)
public class DruidStatFilter extends WebStatFilter {

}
