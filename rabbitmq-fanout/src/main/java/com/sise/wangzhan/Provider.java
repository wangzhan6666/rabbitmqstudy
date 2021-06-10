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
 *  @date: 2021/6/10 20:04 
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

        // 将通道声明指定交换机
        // 参数1：交换机名称
        // 参数2：交换机类型  fanout 广播类型
        channel.exchangeDeclare("logs", "fanout");

        for (int i = 0; i < 10; i++) {
            // 发送消息
            // 参数1：交换机名称
            // 参数2：路由key
            channel.basicPublish("logs", "", null, ("hello fanout - " + i).getBytes());
        }

        // 释放资源
        ConnectionUtils.closeConnectionAndChannel(channel, connection);
    }
}
