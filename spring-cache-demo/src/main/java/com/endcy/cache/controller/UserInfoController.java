package com.endcy.cache.controller;

import com.endcy.cache.dto.UserInfo;
import com.endcy.cache.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "find")
    public UserInfo findUser(@RequestParam(value = "id") Integer id) {
        return userInfoService.findUser(id);
    }

    @GetMapping(value = "delete")
    public String deleteUser(@RequestParam(required = true) Integer id) {
        return "删除成功";
    }
}
