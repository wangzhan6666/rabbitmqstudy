package com.sise.wangzhan;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.ConnectionUtil
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/9 10:43 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/9    acer     v1.0.0      修改原因
 */
public class ConnectionUtils {

    // 创建连接mq的连接工厂对象
    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    static {
        // 重量级资源   类加载执行只执行一次

        // 设置连接rabbitmq主机
        connectionFactory.setHost("127.0.0.1");
        // 设置端口号
        connectionFactory.setPort(5672);
        // 设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/wangzhan");
        // 设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("wangzhan");
        connectionFactory.setPassword("wangzhan");
    }

    // 定义提供链接对象的方法
    public static Connection getConnection(){

        try {

            return connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    // 关闭通道和关闭连接工具方法
    public static void closeConnectionAndChannel(Channel channel, Connection conn){
        try {
            if (channel != null){
                channel.close();
            }

            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
