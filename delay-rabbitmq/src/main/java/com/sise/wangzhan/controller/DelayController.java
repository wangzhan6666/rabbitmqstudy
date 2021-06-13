package com.sise.wangzhan.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.controller.DelayController
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/13 17:42 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/13    acer     v1.0.0      修改原因
 */
@RestController
@RequestMapping("test")
public class DelayController {

    // 注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // http://localhost:8095/test/sendMessage?msg=zhazha666
    @GetMapping("sendMessage")
    public String sendMessage(String msg){

        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", msg);

        /**
         *  参数1：队列名称
         *  参数2：消息
         *  参数3：消息处理器
         */
        /*rabbitTemplate.convertAndSend("delayQueue", map, new MessagePostProcessor() {
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置消息的过期时间,20秒
                message.getMessageProperties().setExpiration("20000");
                return message;
            }
        });*/

        // 在延时队列中指定了过期时间
        rabbitTemplate.convertAndSend("delayQueue", map);

        System.out.println("发送消息的时间：" + new Date());
        return "SUCCESS";
    }
}
