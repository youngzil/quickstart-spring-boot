/**
 * 项目名称：msgframe-console4 
 * 文件名：AdminQueryAspect.java
 * 版本信息：
 * 日期：2017年8月2日
 * Copyright asiainfo Corporation 2017
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * AdminQueryAspect
 * 
 * @author：youngzil@163.com
 * @2017年8月2日 下午3:24:45
 * @version 2.0
 */
@Aspect
@Service
public class AdminQueryAspect {

    private static final Logger logger = LoggerFactory.getLogger(AdminQueryAspect.class);

    public AdminQueryAspect() {}

    /**
     * 定义拦截规则：拦截com.ai.aif.msgframe.service包下面的所有类中，有@AdminQueryMethod注解的方法。
     */
    @Pointcut("execution(* com.ai.aif.msgframe.service.impl..*.*(..)) && @annotation(com.ai.aif.msgframe.aspect.annotation.AdminQueryMethod)")
    public void serviceAdminQueryMethodPointcut() {}

    @Around("serviceAdminQueryMethodPointcut()")
    public Object aroundServiceAdminQueryMethod(ProceedingJoinPoint pjp) throws Throwable {

        Object result = null;
        try {

            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod(); // 获取被拦截的方法
            logger.debug("请求方法名称：" + method);
            // String methodName = method.getName(); // 获取被拦截的方法名
            // AdminQueryMethod adminQueryMethod =
            // method.getAnnotation(AdminQueryMethod.class);

            /*User userInfo = SessionHandle.getUserInfo();
            if (null == userInfo) {
                ResponseData data = new ResponseData();
                data.setRetCode("USER_NOT_LOGIN or USER_LOGIN_TIMEOUT");
                data.setRetInfo("没有登录或者登陆超时");
                result = data;
            }
            
            if (null == result) {
                Object[] args = pjp.getArgs();
                for (Object arg : args) {
                    if (arg instanceof CommonRequest) {
                        CommonRequest pageRequest = (CommonRequest) arg;
                        if (!userInfo.isAdministrator()) {
                            String centerId = userInfo.getCenterId();
                            if (StringUtils.isBlank(centerId)) {
                                pageRequest.setCenterId("-1");
                            } else {
                                pageRequest.setCenterId(centerId);
                            }
                        }
                    }
                }
            
            }*/

        } catch (Exception e) {
            logger.error("exception: ", e);
        }

        if (null == result) {
            // 一切正常的情况下，继续执行被拦截的方法
            result = pjp.proceed();
        }

        return result;
    }

}
