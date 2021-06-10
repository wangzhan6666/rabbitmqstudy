package com.sise.wangzhan;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.Provider
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/8 16:58 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/8    acer     v1.0.0      修改原因
 */
public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {

        /*// 创建连接mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接rabbitmq主机
        connectionFactory.setHost("127.0.0.1");
        // 设置端口号
        connectionFactory.setPort(5672);
        // 设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/wangzhan");
        // 设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("wangzhan");
        connectionFactory.setPassword("wangzhan");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();*/

        // 通过工具类获取连接
        Connection connection = ConnectionUtils.getConnection();

        // 获取连接中的通道
        Channel channel = connection.createChannel();

        // 通过绑定对应消息队列
        // 参数1：队列名称 如果队列不存在自动创建
        // 参数2：用来定义队列特性是否要持久化 true 持久化队列  false 不持久化
        // 参数3：是否独占队列  true独占队列   false不持久化
        // 参数4：是否在消费完成后自动删除队列  true 自动删除   false不自动删除
        // 参数5：额外附加参数
        channel.queueDeclare("hello", false, false, false, null);

        // 发布消息
        // 参数1：交换机名称
        // 参数2：队列名称
        // 参数3：传递消息额外设置     MessageProperties.PERSISTENT_TEXT_PLAIN：消息持久化
        // 参数4：消息的具体内容
        channel.basicPublish("", "hello", null, "hello rabbitmq".getBytes());

//        channel.close();
//        connection.close();

        // 通过工具类关闭连接
        ConnectionUtils.closeConnectionAndChannel(channel, connection);
    }
}
