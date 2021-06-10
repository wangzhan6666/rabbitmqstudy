package com.sise.wangzhan;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.Provider
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/10 21:03 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
public class Provider {
    public static void main(String[] args) throws IOException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        // 声明交换机
        channel.exchangeDeclare("topic-exchange", "topic");

        for (int i = 0; i < 10; i++) {
            // 发布消息
            channel.basicPublish("topic-exchange", "user.test", null, ("hello topic - " + i).getBytes());
        }

        ConnectionUtils.closeConnectionAndChannel(channel, connection);
    }
}
