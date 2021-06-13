package com.sise.wangzhan.service.impl;

import com.sise.wangzhan.service.IDirectCustomer2;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.service.impl.DirectCustomer2Impl
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/12 10:31 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/12    acer     v1.0.0      修改原因
 */
@Service
public class DirectCustomer2Impl implements IDirectCustomer2 {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "newDirectExchange", type = "direct"),
                    key = {"error"}
            )
    })
    public void receiveMessage(String message) {
        System.out.println("消费者2：" + message);
    }
}
