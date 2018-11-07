package com.endcy.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/27.
 * Version      : 1.0
 * ***************************************************************************
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient2Application {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(EurekaClient2Application.class, args);
//        ApplicationContext appContext = new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }
}
