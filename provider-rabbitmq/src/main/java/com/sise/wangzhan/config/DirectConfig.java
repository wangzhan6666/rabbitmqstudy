package com.sise.wangzhan.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.config.DirectConfig
 *  @Description: 确保交换机等信息存在
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/11 23:21 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/11    acer     v1.0.0      修改原因
 */
// 确保交换机等信息存在
@Configuration
public class DirectConfig {

    // 声明交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("newDirectExchange");
    }

    // 声明队列
    /*@Bean
    public Queue queue1(){
        return new Queue("newDirectQueue1");
    }*/

    /*@Bean
    public Queue queue2(){
        return new Queue("newDirectQueue2");
    }*/

    // 绑定交换机和队列
    /*@Bean
    public Binding binding(Queue queue1, DirectExchange directExchange){
        return BindingBuilder.bind(queue1).to(directExchange).with("error");
    }*/

    /*// 绑定交换机和队列
    @Bean
    public Binding binding2(Queue queue2, DirectExchange directExchange){
        return BindingBuilder.bind(queue2).to(directExchange).with("error");
    }*/
}
