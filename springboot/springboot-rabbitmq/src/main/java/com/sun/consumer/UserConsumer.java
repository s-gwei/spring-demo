package com.sun.consumer;

import com.sun.pojo.User;
import com.sun.service.IUserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @description: user消费者
 * @author: sungw
 * @create: 2022-07-17 12:00
 **/
@Component
@RabbitListener(queues = {"userQueue"})
public class UserConsumer {

    @Autowired
    private IUserService userService;

    @RabbitHandler
    public void createUser(User user){
        userService.save(user);

    }
}
