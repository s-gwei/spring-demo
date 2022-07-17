package com.sun.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: user配置mq信息
 * @author: sungw
 * @create: 2022-07-17 11:54
 **/
@Configuration
public class UserConfig {
    /**设置交换机*/
    private static final String USER_EXCHANGE = "userExchange";

    /**设置队列*/
    private static final String USER_QUEUE = "userQueue";

    /**声明交换机*/
    @Bean("userExchange")
    public DirectExchange userExchange(){
        return new DirectExchange(USER_EXCHANGE);
    }

    /** 声明队列*/
    /**声明mapQueue*/
    @Bean("userQueue")
    public Queue userQueue(){
        return QueueBuilder.durable(USER_QUEUE).build();
    }

    /**队列和交换机绑定*/
    @Bean
    public Binding userQueueBinding(@Qualifier("userQueue") Queue userQueue,
                                   @Qualifier("userExchange") Exchange userExchange){
        return BindingBuilder.bind(userQueue).to(userExchange).with("userRoutingKey").noargs();
    }
}
