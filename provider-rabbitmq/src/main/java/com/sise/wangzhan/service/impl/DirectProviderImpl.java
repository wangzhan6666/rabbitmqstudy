package com.sise.wangzhan.service.impl;

import com.sise.wangzhan.service.IDirectProvider;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.service.impl.DirectProviderImpl
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/11 23:05 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/11    acer     v1.0.0      修改原因
 */
@Service("directProviderService")
public class DirectProviderImpl implements IDirectProvider {

    // 注入Amqp的模板类，利用这个对象来发送和接收消息
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        // 发送消息
        // 参数1：交换机名称
        // 参数2：路由key
        // 参数3：需要发送的消息内容
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("newDirectExchange", "error", message + i);
        }
    }
}
