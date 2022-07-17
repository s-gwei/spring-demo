package com.sun.controller;

import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 消息是对象，json
 * @author: sungw
 * @create: 2022-07-16 17:44
 **/
@RestController
@RequestMapping("map")
@Slf4j
public class MapController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public void getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","第一次发送消息");
        log.info("当前时间:{},发送一条消息给队列：{}",new Date().toString(),map.toString());
        rabbitTemplate.getMessageConverter();
        rabbitTemplate.convertAndSend("mapExchange","mapRoutingKey", map);
    }

    @GetMapping("/test1")
    public void getUser1(){
        User user = new User(1, "sungw");
        log.info("当前时间:{},发送一条消息给两个TTL队列：{}",new Date().toString(),user);
        rabbitTemplate.convertAndSend("xExchange","xRoutingKey", user);
    }

}
