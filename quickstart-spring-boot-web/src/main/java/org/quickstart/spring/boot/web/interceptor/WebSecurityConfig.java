/**
 * 项目名称：msgframe-console3 
 * 文件名：WebSecurityConfig.java
 * 版本信息：
 * 日期：2017年7月12日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * WebSecurityConfig
 * 
 * @author：youngzil@163.com
 * @2017年7月12日 上午10:06:34
 * @version 1.0
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSecurityInterceptor()).
        // 排除配置
                excludePathPatterns("/error")//
                .excludePathPatterns("/ipassLogin")//
                .excludePathPatterns("/login")//
                .excludePathPatterns("/user/register")//
                .excludePathPatterns("/user/updatePassword")//
                .excludePathPatterns("/api/getMsgframeConfig")//
                .excludePathPatterns("/openapi/createLessee")//
                // excludePathPatterns("/**").

                // 拦截配置
                .addPathPatterns("/**");
    }

    /**
     * 解决跨域问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        // @Autowired
        // private UserService userService;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            HttpSession session = request.getSession();

            // 使用admin用户自动登录
            /*if (null == session.getAttribute(BaseConstant.LOGIN_SESSION_KEY)) {
                User user = new User();
                user.setUserCode("admin");
                user.setPassword("admin");
                List<User> userList = userService.get(user);
                session.setAttribute(BaseConstant.LOGIN_SESSION_KEY, userList.get(0));
            }*/
            /*
            if (session.getAttribute(BaseConstant.LOGIN_SESSION_KEY) != null) {
            
                User user = (User) request.getSession().getAttribute(BaseConstant.LOGIN_SESSION_KEY);
            
                if (userService.isBlackUser(user.getUserId())) {
            
                    ResponseData data = new ResponseData();
                    data.setRetCode("416");
                    data.setRetInfo("permission denied:Request operation rejection");
                    // 返回json信息
                    response.getWriter().write(JSON.toJSONString(data));
                    return false;
            
                }
            
                // TODO session每次请求都重新存放，没有必要
                SessionStatus sessionStatus = new SimpleSessionStatus();
                SessionHandle.init(request, sessionStatus);
                return true;
            }
            
            // 跳转登录
            // String url = "/";
            // response.sendRedirect(url);
            // request.getRequestDispatcher(url).forward(request, response);
            
            // 设置会话失效
            // 416 Requested range not satisfiable 客户端请求的范围无效
            ResponseData data = new ResponseData();
            data.setRetCode("416");
            data.setRetInfo("Requested range not satisfiable");
            
            // 返回json信息
            response.getWriter().write(JSON.toJSONString(data));
            */
            return false;
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            // SessionHandle.clear();
        }

    }
}
