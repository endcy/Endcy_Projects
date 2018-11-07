package com.endcy.eurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/27.
 * Version      : 1.0
 * ***************************************************************************
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer2Application {
    public static void main(String[] args) {
//        ApplicationContext app = SpringApplication.run(EurekaServerApplication.class, args);
        ApplicationContext appContext = new SpringApplicationBuilder(EurekaServer2Application.class).web(true).run(args);
    }
}
