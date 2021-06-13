package com.sise.wangzhan;

import com.sise.wangzhan.service.IDirectCustomer1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.Customer1Application
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/11 23:37 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/11    acer     v1.0.0      修改原因
 */
@SpringBootApplication
public class Customer1Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Customer1Application.class, args);

        // 使用监听器箭头消息，不需要使用下面的步骤

        //IDirectCustomer1 directCustomer1 = applicationContext.getBean("directCustomer1Service", IDirectCustomer1.class);

        //directCustomer1.receiveMessage();
    }
}
