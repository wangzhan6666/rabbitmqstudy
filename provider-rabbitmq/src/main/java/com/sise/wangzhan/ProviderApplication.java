package com.sise.wangzhan;

import com.sise.wangzhan.service.IDirectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *  Copyright: Copyright (c) 2021 Asiainfo
 *  
 *  @ClassName: com.sise.wangzhan.ProviderApplication
 *  @Description: 该类的功能描述
 * <p>
 *  @version: v1.0.0
 *  @author:   wangzhan
 *  @date: 2021/6/11 23:02 
 * <p>
 *  Modification History:
 *  Date       Author    Version    Description
 * ----------------------------------------------------------
 *  2021/6/11    acer     v1.0.0      修改原因
 */
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ProviderApplication.class, args);

        IDirectProvider directProvider = applicationContext.getBean("directProviderService", IDirectProvider.class);

        directProvider.sendMessage("zhazha is 666 - ");

    }
}
