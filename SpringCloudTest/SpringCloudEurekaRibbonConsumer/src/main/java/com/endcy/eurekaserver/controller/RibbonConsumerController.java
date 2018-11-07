package com.endcy.eurekaserver.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/27.
 * Version      : 1.0
 * ***************************************************************************
 */
@RestController
public class RibbonConsumerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String test() {
        // restTemplate.getForObject("http://Eureka-Client-Test/client", String.class);
        // get使用getForEntity或者getForObject；
        // post使用postForEntity或者postForObject，或者返回URI资源的postForLocation
        // put()及delete()方法类似getForObject
        return restTemplate.getForEntity("http://Eureka-Client-Test/client", String.class).getBody();
        //EUREKA_CLIENT_TEST 是Client的application.name
//        return "Eureka Ribbon Consumer OK!";
    }
}
