package com.endcy.taskdemo.controller;

import com.endcy.taskdemo.service.impl.TaskPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cxx
 * @date 2021/6/27 15:35
 **/
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskPortalService taskPortalService;

    @GetMapping("/start")
    public String start(@RequestParam(value = "type",required = false) String type) {
        taskPortalService.startTask(type);
        return "ok";
    }

}
