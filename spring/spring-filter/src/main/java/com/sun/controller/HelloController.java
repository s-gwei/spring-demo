package com.sun.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sungw
 * @Date 2023/2/9 20:38
 **/
@RestController()
public class HelloController {

    @RequestMapping("/hello/{id}")
    public String hello(@PathVariable("id")String id){
        return "hello"+id;
    }
}
