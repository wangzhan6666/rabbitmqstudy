package com.sise.wangzhan.service.impl;

import com.sise.wangzhan.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.service.impl.SendServiceImpl
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/11 22:30 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/11    acer     v1.0.0      修改原因
 */
@Service("sendService")
public class SendServiceImpl implements SendService {

    // 注入Amqp的模板类，利用这个对象来发送和接收消息
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("newDirectExchange", "error", message);
    }
}
