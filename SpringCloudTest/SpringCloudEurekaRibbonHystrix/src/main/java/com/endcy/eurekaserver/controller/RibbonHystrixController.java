package com.endcy.eurekaserver.controller;

import com.endcy.eurekaserver.cloudservice.HystrixConService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/8/27.
 * Version      : 1.0
 * ***************************************************************************
 */
@RestController
public class RibbonHystrixController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private HystrixConService hystrixConService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String test() {
        return hystrixConService.hystrixConService();
    }
}
