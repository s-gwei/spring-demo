package com.sun.point;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Author sungw
 * @Date 2023/2/9 20:43
 **/
@Aspect
@Component
public class MyAdvice {

    private Logger logger = LoggerFactory.getLogger(MyAdvice.class);

    //设置切面信息
    @Pointcut(value = "execution(* com.sun.controller.*.*(..))")
    public void myPoint(){

    }

    @Around("myPoint()")
    private Object myLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] array = proceedingJoinPoint.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();

        logger.info("调用前"+className+":"+methodName+"请求的参数为："+objectMapper.writeValueAsString(array));

        Object object = proceedingJoinPoint.proceed();

        logger.info("调用前"+className+":"+methodName+"返回的值为："+objectMapper.writeValueAsString(object));

        return object;
    }

    @Before("myPoint()")
    public void before(JoinPoint joinPoint) throws Throwable{
        Object[] objs = joinPoint.getArgs();
        for (Object obj : objs) {
            System.out.println("前置通知接受的参数:"+obj);
        }
    }


    @AfterReturning(returning = "object", pointcut = "myPoint()")
    public void doAfterReturning(Object object) {

        System.out.println("后通知响应的参数:"+object.toString());
    }


}
