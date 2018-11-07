package com.endcy.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
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
//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication
// 上面三个注解相当于下面一个
@SpringCloudApplication
public class EurekaRibbonHystrixApplication {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(EurekaRibbonHystrixApplication.class, args);
//        ApplicationContext appContext = new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }

    @Bean           //注册为Bean
    @LoadBalanced   //开启客户端负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
