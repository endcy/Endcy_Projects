package com.endcy.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
public class EurekaRibbonConsumerApplication {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(EurekaRibbonConsumerApplication.class, args);
//        ApplicationContext appContext = new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }

    @Bean           //注册为Bean
    @LoadBalanced   //开启客户端负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
