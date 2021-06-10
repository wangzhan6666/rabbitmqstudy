package com.sise.wangzhan;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.TestRabbitmq
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/10 21:52 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
@SpringBootTest(classes = WorkqueuesAnnotion.class)
public class TestRabbitmq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){

        for (int i = 0; i < 10; i++) {
            // 参数1：队列名称
            // 参数2：消息
            rabbitTemplate.convertAndSend("workqueues-annotion", "hello workqueues - " + i);
        }

    }
}
