package com.sise;

import com.sise.wangzhan.RabbitmqHelloWorldAnnotion;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.TestRabbitmq
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/10 21:37 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
@SpringBootTest(classes = RabbitmqHelloWorldAnnotion.class)
public class TestRabbitmq {

    // 注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 由消费者创建队列
    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello-annotion", "hello world");
    }
}
