package com.sun.config;

import com.sun.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: main的配置类
 * @author: sungw
 * @create: 2022-07-23 13:11
 **/
/**配置类注解，相当于一个xml文件,同时也会创建一个bean*/
@Configuration
/**包扫描注解，includeFilters,excludeFilters配置扫描规则*/
@ComponentScan("com.sun")
public class MainConfig {

    /** bean注解，给容器注册一个bean，类型是返回值类型，名称默认是方法名，不过可以修改*/
    @Bean("person")
    public Person person01(){
        return new Person("sungw", 27);
    }
}
