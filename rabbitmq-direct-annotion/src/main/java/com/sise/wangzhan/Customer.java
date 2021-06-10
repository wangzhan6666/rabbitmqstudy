package com.sise.wangzhan;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
 *  @date: 2021/6/10 22:26 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
@Component
public class Customer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "direct-annotion",type = "direct"),
                    key = {"error"}
            )
    })
    public void receive1(String message){
        System.out.println("消费者1：" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "direct-annotion", type = "direct"),
                    key = {"error", "info", "warning"}
            )
    })
    public void receive2(String message){
        System.out.println("消费者2：" + message);
    }
}
