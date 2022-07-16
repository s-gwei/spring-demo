package com.sun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 发string类型的消息
 * @author: sungw
 * @create: 2022-07-16 17:23
 **/
@RestController
@RequestMapping("String")
@Slf4j
public class StringController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/get")
    public String getUser(){
        String message = "hello world";
        log.info("当前时间:{},发送一条消息给队列：{}",new Date().toString(),message);
        rabbitTemplate.convertAndSend("xExchange","xRoutingKey", message);
        return message;
    }
}
