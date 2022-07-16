package com.sun.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: map交换机和队列
 * @author: sungw
 * @create: 2022-07-16 17:46
 **/
@Configuration
public class MapConfig {
    /**设置交换机*/
    private static final String MAP_EXCHANGE = "mapExchange";

    /**设置队列*/
    private static final String MAP_QUEUE = "mapQueue";

    /**声明交换机*/
    @Bean("mapExchange")
    public DirectExchange mapExchange(){
        return new DirectExchange(MAP_EXCHANGE);
    }

    /** 声明队列*/
    /**声明mapQueue*/
    @Bean("mapQueue")
    public Queue mapQueue(){
        return QueueBuilder.durable(MAP_QUEUE).build();
    }

    /**队列和交换机绑定*/
    @Bean
    public Binding mapQueueBinding(@Qualifier("mapQueue") Queue mapQueue,
                                @Qualifier("mapExchange") Exchange mapExchange){
        return BindingBuilder.bind(mapQueue).to(mapExchange).with("mapRoutingKey").noargs();
    }
}
