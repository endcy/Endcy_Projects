package com.endcy.eurekaserver.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/27.
 * Version      : 1.0
 * ***************************************************************************
 */
@RestController
public class EurekaClientController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String test() {
        //获取所有Client对应在服务中心的信息
        List<ServiceInstance> instances = client.getInstances(appName);
        for (ServiceInstance instance : instances) {
            logger.info("Eureka Server:" + instance.getHost() + ", ServiceID:" + instance.getServiceId());
        }
        return "Client OK!";
    }
}
