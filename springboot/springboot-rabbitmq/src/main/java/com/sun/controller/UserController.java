package com.sun.controller;

import com.sun.pojo.User;
import com.sun.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: user控制类
 * @author: sungw
 * @create: 2022-07-17 11:48
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IUserService userService;

    @PostMapping
    public void createUserByMQ(){
        log.info("创建10000条user");
        for(int i=0; i<10000; i++)
        rabbitTemplate.convertAndSend("userExchange","userRoutingKey",new User(i, "sungw"+i));
    }

    @GetMapping
    public List<User> selectUser(){
        return userService.selectUser();
    }
}
