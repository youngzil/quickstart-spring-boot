/**
 * 项目名称：msgframe-console4 
 * 文件名：HTTPBasicAuthorizeAttribute.java
 * 版本信息：
 * 日期：2017年8月1日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * HTTPBasicAuthorizeAttribute
 * 
 * @author：youngzil@163.com
 * @2017年8月1日 下午6:36:39
 * @version 2.0
 */
public class MyFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper((HttpServletRequest) request);
        requestWrapper.addParameter("fff", "我靠");
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
