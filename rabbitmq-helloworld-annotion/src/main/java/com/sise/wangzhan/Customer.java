package com.sise.wangzhan;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.Customer
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/10 21:42 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello-annotion", durable = "false"))
public class Customer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("消费者：" + message);
    }

}
