package com.sise.wangzhan.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.listener.MessageListener
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/13 17:49 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/13    acer     v1.0.0      修改原因
 */
// 监听死信队列
@RabbitListener(queues = "deadQueue")
@Component
public class MessageListener {

    @RabbitHandler
    public void receive(Map<String, String> map){
        System.out.println("接收消息的时间：" + new Date());
        System.out.println("从MQ中接收到的消息：" + map.get("msg"));
    }
}
