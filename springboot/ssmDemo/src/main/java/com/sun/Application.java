package com.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @description: rabbitm启动类
 * @author: sungw
 * @create: 2022-07-16 16:46
 **/
@SpringBootApplication(scanBasePackages = {"com.sun.*"})
@MapperScan("com.sun.dao")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
