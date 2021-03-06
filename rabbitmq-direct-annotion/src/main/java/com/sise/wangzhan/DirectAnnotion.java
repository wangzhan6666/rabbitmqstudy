package com.sise.wangzhan;

import com.sise.wangzhan.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.DirectAnnotion
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/10 22:26 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/10    acer     v1.0.0      修改原因
 */
@SpringBootApplication
public class DirectAnnotion {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DirectAnnotion.class, args);

        SendService sendService = applicationContext.getBean("sendService", SendService.class);

        sendService.sendMessage("zhazha is 666");
    }
}
