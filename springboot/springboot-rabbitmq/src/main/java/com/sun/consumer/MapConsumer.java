package com.sun.consumer;

import com.sun.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @description: 消费map数据
 * @author: sungw
 * @create: 2022-07-16 17:48
 **/
@Component
@Slf4j
@RabbitListener(queues = {"mapQueue"})
public class MapConsumer {

    @RabbitHandler
    public void process(Map map){
        log.info("当前时间为{}，收到延迟消息为{}", new Date(), map.toString());
    }

    @RabbitHandler
    public void process1(User user){
        log.info("当前时间为{}，收到延迟消息为{}", new Date(), user.toString());
    }
}
