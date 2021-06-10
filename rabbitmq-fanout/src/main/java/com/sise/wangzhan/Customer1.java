package com.sise.wangzhan;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.Customer1
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/10 20:18 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
public class Customer1 {
    public static void main(String[] args) throws IOException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        // 通道绑定交换机
        // 参数1：交换机名称
        // 参数2：交换机类型
        channel.exchangeDeclare("logs", "fanout");

        // 临时队列
        String queueName = channel.queueDeclare().getQueue();

        // 绑定交换机和队列
        // 参数1：临时队列名称
        // 参数2：交换机名称
        // 参数3：路由key
        channel.queueBind(queueName, "logs", "");

        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1：" + new String(body));
            }
        });
    }
}
