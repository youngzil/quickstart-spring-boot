/**
 * 项目名称：msgframe-console 
 * 文件名：LoggingAspect.java
 * 版本信息：
 * 日期：2018年4月11日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.spring.boot.web.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * LoggingAspect
 * 
 * @author：youngzil@163.com
 * @2018年4月11日 下午5:11:16
 * @since 1.0
 */
@Aspect
@Component
public class LoggingAspect {

    // 日志记录
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // @Autowired
    // private OperationLogService operationLogService;

    @Pointcut("@annotation(com.ai.aif.msgframe.aspect.annotation.Logger)")
    public void loggerMethodPointcut() {}

    /**
     * 统计Service中方法调用的时间 logServiceMethodAccess
     * 
     * @Description:
     * @param joinPoint
     * @return
     * @throws Throwable Object
     * @Exception
     * @author：youngzil@163.com
     * @2018年4月11日 下午5:32:23
     * @since 1.0
     */
    // @Around("execution(* com.ai.aif.msgframe.service..*.*(..))")
    // @Around("execution(* com.ai.aif.msgframe..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping) ")
    @Around("loggerMethodPointcut()")
    public Object logServiceMethodAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {

            try {
                long costTime = System.currentTimeMillis() - start;
                String className = joinPoint.getSignature().toString();
                Object[] args = joinPoint.getArgs();

                ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = sra.getRequest();

                OperationLog operLog = new OperationLog();
                operLog.setRemoteHost(request.getRemoteHost() + ":" + request.getRemotePort());
                operLog.setServerInfo(request.getServerName() + ":" + request.getServerPort());

                operLog.setClassName(className);
                operLog.setParam(String.valueOf(args));
                operLog.setOperTime(new Date());
                operLog.setCostTime((int) costTime);

                String exceptionInfo = String.valueOf(e);
                if (exceptionInfo.length() > 4000) {
                    exceptionInfo = exceptionInfo.substring(0, 4000);
                }
                operLog.setExceptionInfo(exceptionInfo);

                // operationLogService.insert(operLog);
            } catch (Exception ex) {
                logger.error("record operation log exception: ", ex);
            }

            logger.error("exception: ", e);
            throw e;
        }

        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method1 = signature.getMethod(); // 获取被拦截的方法
            logger.debug("请求方法名称：" + method1);
            // String methodName = method.getName(); // 获取被拦截的方法名
            String description1 = method1.getAnnotation(org.quickstart.spring.boot.web.aspect.Logger.class).description();

            Object object = joinPoint.getTarget();
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));

            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();

            long costTime = System.currentTimeMillis() - start;
            String className = joinPoint.getSignature().toString();
            Object[] args = joinPoint.getArgs();

            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = sra.getRequest();

            OperationLog operLog = new OperationLog();
            operLog.setRemoteHost(request.getRemoteHost() + ":" + request.getRemotePort());
            operLog.setServerInfo(request.getServerName() + ":" + request.getServerPort());

            operLog.setClassName(className);
            operLog.setParam(Arrays.toString(args));
            operLog.setOperTime(new Date());
            operLog.setCostTime((int) costTime);
            // operationLogService.insert(operLog);
        } catch (Exception e) {
            logger.error("record operation log exception: ", e);
        }

        return result;
    }

}
