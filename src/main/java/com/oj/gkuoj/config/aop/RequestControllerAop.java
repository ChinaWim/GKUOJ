package com.oj.gkuoj.config.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author m969130721@163.com
 * @date 18-8-29 上午11:41
 */
@Aspect
@Component
public class RequestControllerAop {

    private static Logger logger = LoggerFactory.getLogger(RequestControllerAop.class);

    private static boolean debug = false;

    @Value("${project.debug}")
    public void setIsDebug(boolean debug) {
        if (debug) {
            logger.info("当前项目为debug模式");
        }
        RequestControllerAop.debug = debug;
    }

    @Around("execution(* com.oj.gkuoj.rest.*.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//        logger.info("请求IP:"+request.getRemoteHost());
        Class<?> clazz = point.getTarget().getClass();
        Logger log = LoggerFactory.getLogger(clazz);
        if (debug) {
            MethodSignature ms = (MethodSignature) point.getSignature();
            Method method = clazz.getMethod(ms.getName(), ms.getParameterTypes());
            if (clazz.getAnnotation(RestController.class) != null || method.getAnnotation(ResponseBody.class) != null) {
                log.info("是否是ResponseBody:是");
            } else {
                log.info("是否是ResponseBody:否");
            }
            log.info("执行类:" + clazz.getName());
            log.info("方法:" + method.getName());
        }
        Object returnValue = point.proceed();
        if (debug) {
            if (returnValue == null) {
                log.info("没有返回值");
            } else {
                log.info("返回值:" + returnValue);
            }
            log.info("******************************************************************" +
                    "******************************************************************" +
                    "*******************************************************************");
        }
        return returnValue;
    }

}
