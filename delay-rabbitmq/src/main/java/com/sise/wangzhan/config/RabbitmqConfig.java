package com.sise.wangzhan.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.config.RabbitmqConfig
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/13 17:29 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/13    acer     v1.0.0      修改原因
 */
@Configuration
public class RabbitmqConfig {

    // 延时队列
    @Bean
    public Queue delayQueue(){
        // 设置死信交换机及路由key
        return QueueBuilder.durable("delayQueue")   // 持久化队列
                // 死信交换机，如果消息过时，则会被投递到当前对应的交换机中
                .withArgument("x-dead-letter-exchange", "myDeadExchange")
                // 路由key，如果消息过时，交换机会根据路由key投递消息到对应的队列
                .withArgument("x-dead-letter-routing-key", "delayRoutingKey")
                .build();
    }

    // 死信交换机
    @Bean
    public Exchange deadExchange(){
        return ExchangeBuilder.directExchange("myDeadExchange").build();
    }

    // 死信队列
    @Bean
    public Queue deadQueue(){
        return QueueBuilder.durable("deadQueue").build();
    }

    // 绑定死信交换机和死信队列
    @Bean
    public Binding binding(@Qualifier("deadExchange") Exchange exchange,
                           @Qualifier("deadQueue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("delayRoutingKey").noargs();
    }
}
