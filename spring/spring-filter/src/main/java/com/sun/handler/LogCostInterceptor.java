package com.sun.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author sungw
 * @Date 2023/2/9 23:06
 * 过滤器和拦截器非常相似，但是它们有很大的区别
 * 最简单明了的区别就是**过滤器可以修改request，而拦截器不能
 * 过滤器需要在servlet容器中实现，拦截器可以适用于javaEE，javaSE等各种环境
 * 拦截器可以调用IOC容器中的各种依赖，而过滤器不能
 * 过滤器只能在请求的前后使用，而拦截器可以详细到每个方法**
 * 区别很多，大家可以去查下
 **/
@Component
public class LogCostInterceptor implements HandlerInterceptor {

    long start = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
