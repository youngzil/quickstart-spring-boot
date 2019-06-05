/**
 * 项目名称：quickstart-spring-boot 
 * 文件名：ControllerInterceptor.java
 * 版本信息：
 * 日期：2017年7月8日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.aspect;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.quickstart.spring.boot.web.annotation.Permission;
import org.quickstart.spring.boot.web.result.JsonResult;
import org.quickstart.spring.boot.web.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
	 * 此后 讲解下Aspect 几个通知注解(advice)
	 * @Pointcut 拦截的切入点方法，注解的在方法级别之上，但是不执行方法体，只表示切入点的入口。
	 * @Before 顾名思义 是在 切入点 之前执行 方法。
	 * @AfterReturning 返回拦截方法的返回值
	 * @AfterThrowing 拦截的方法 如果抛出异常 加执行此方法 throwing="ex" 将异常返回到参数列表
	 * @After 在之上方法执行后执行结束操作
	 * @Around 判断是否执行 以上的拦截 ，第一个参数必须ProceedingJoinPoint. 如要拦截：
	 * 
	 * @Pointcut("execution(*com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")//
	 *@Pointcut("within(com.test.spring.aop.pointcutexp..*)")//
	* @Pointcut("this(com.test.spring.aop.pointcutexp.Intf)")//
	* @Pointcut("target(com.test.spring.aop.pointcutexp.Intf)")//
	* @Pointcut("@within(org.springframework.transaction.annotation.Transactional)")//
	* @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")//
	* @Pointcut("args(String)")//
	 */
/**
 * ControllerInterceptor 拦截器：记录用户操作日志，检查用户是否登录……
 * 
 * @author：youngzil@163.com
 * @2017年7月8日 下午5:29:30
 * @version 1.0
 */
@Aspect
@Service
public class ControllerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    // @Value("${spring.profiles.active}")
    private String env = "dev";

    /**
     * 定义拦截规则：拦截org.quickstart.spring.boot.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* org.quickstart.spring.boot.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {}

    /**
     * 拦截器具体实现
     * 
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()") // 指定拦截器规则；也可以直接把“execution(*org.quickstart.spring.........)”写进这里
    public Object Interceptor(ProceedingJoinPoint pjp) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); // 获取被拦截的方法
        String methodName = method.getName(); // 获取被拦截的方法名

        /*
         * MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
         * if (myAnnotation != null && myAnnotation.timeoutMillis() > 0) {
         * logger.debug("MyAnnotation timeoutMillis is ：" +
         * myAnnotation.timeoutMillis()); } else {
         * logger.debug("MyAnnotation timeoutMillis is default"); }
         */

        Set<Object> allParams = new LinkedHashSet<>(); // 保存所有请求参数，用于输出到日志中

        logger.info("请求开始，方法：{}", methodName);

        Object result = null;

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            // logger.debug("arg: {}", arg);
            if (arg instanceof Map<?, ?>) {
                // 提取方法中的MAP参数，用于记录进日志中
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map<String, Object>) arg;

                allParams.add(map);
            } else if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) arg;
                if (isLoginRequired(method)) {
                    if (!isLogin(request)) {
                        result = new JsonResult(ResultCode.NOT_LOGIN, "该操作需要登录！去登录吗？\n\n（不知道登录账号？请联系admin。）", null);
                    }
                }

                // 获取query string 或 posted form data参数
                Map<String, String[]> paramMap = request.getParameterMap();
                if (paramMap != null && paramMap.size() > 0) {
                    allParams.add(paramMap);
                }
            } else if (arg instanceof HttpServletResponse) {
                // do nothing...
            } else {
                // allParams.add(arg);
            }
        }

        try {
            if (result == null) {
                // 一切正常的情况下，继续执行被拦截的方法
                result = pjp.proceed();
            }
        } catch (Throwable e) {
            logger.error("exception: ", e);
            result = new JsonResult(ResultCode.EXCEPTION, "发生异常：" + e.getMessage());
        }

        long costMs = System.currentTimeMillis() - beginTime;
        logger.info("{}请求结束，耗时：{}ms", methodName, costMs);

        return result;
    }

    /**
     * 判断一个方法是否需要登录
     * 
     * @param method
     * @return
     */
    private boolean isLoginRequired(Method method) {
        if (!env.equals("prod")) { // 只有生产环境才需要登录
            return false;
        }

        boolean result = true;
        if (method.isAnnotationPresent(Permission.class)) {
            result = method.getAnnotation(Permission.class).loginReqired();
        }

        return result;
    }

    // 判断是否已经登录
    private boolean isLogin(HttpServletRequest request) {
        return true;
        /*
         * String token = XWebUtils.getCookieByName(request,
         * WebConstants.CookieName.AdminToken);
         * if("1".equals(redisOperator.get(RedisConstants.Prefix.ADMIN_TOKEN+
         * token))){ return true; }else { return false; }
         */
    }
}
