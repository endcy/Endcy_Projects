package com.endcy.eurekaserver.cloudservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/29.
 * Version      : 1.0
 * ***************************************************************************
 */
@Service
public class HystrixConService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "conFallback")
    public String hystrixConService() {
        return restTemplate.getForEntity("http://Eureka-Client-Test/client", String.class).getBody();
        //EUREKA_CLIENT_TEST 是Client的application.name
    }

    public String conFallback() {
        return "error";
    }
}
