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
 *  @date: 2021/6/9 11:34 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/9    acer     v1.0.0      修改原因
 */
public class Customer1 {
    public static void main(String[] args) throws IOException {

        Connection connection = ConnectionUtils.getConnection();

        final Channel channel = connection.createChannel();

        channel.queueDeclare("test-workqueues", false, false, false, null);

        // 每次只能消费一个消息
        channel.basicQos(1);
        // 不被自动消费
        channel.basicConsume("test-workqueues", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("消费者1：" + new String(body));
                // 手动确认
                // 参数1：手动去人消息标识
                // 参数2：false  每次确认一个
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
