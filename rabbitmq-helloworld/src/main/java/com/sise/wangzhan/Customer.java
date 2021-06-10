package com.sise.wangzhan;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.Customer
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/9 10:23 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/9    acer     v1.0.0      修改原因
 */
public class Customer {
    public static void main(String[] args) throws IOException, TimeoutException {
        /*ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/wangzhan");
        connectionFactory.setUsername("wangzhan");
        connectionFactory.setPassword("wangzhan");

        Connection connection = connectionFactory.newConnection();*/

        // 通过工具类获取连接
        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        // 要和生产者一致
        channel.queueDeclare("hello", false, false, false, null);

        // 消费消息
        // 参数1：消费哪个队列的消息  队列名称
        // 参数2：开始消息的自动确认机制      消费者自动向rabbitmq确认
        // 参数3：消费时的回调接口
        channel.basicConsume("hello", true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("输出的消息为：" + new String(body));
            }
        });
    }
}
