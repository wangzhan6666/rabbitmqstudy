package com.sise.wangzhan.service.impl;

import com.sise.wangzhan.service.IDirectCustomer1;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.service.impl.DirectCustomer1Impl
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/11 23:39 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/11    acer     v1.0.0      修改原因
 */
@Service("directCustomer1Service")
public class DirectCustomer1Impl implements IDirectCustomer1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 这里的接收不是不间断接收消息，每执行一次这个方法只能接收一次消息，
     * 如果有新消息进入则不会自动接收消息
     */
    public void receiveMessage() {
        String message = (String) amqpTemplate.receiveAndConvert("newDirectQueue1");

        System.out.println(message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "newDirectExchange", type = "direct"),
                    key = {"info", "warning"}
            )
    })
    public void receiveMessage(String message){
        System.out.println("消费者1：" + message);
    }

}
