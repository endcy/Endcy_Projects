package com.endcy.cache.service;

import com.endcy.cache.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class UserInfoService {

    @Cacheable(value = "userCache", key = "'user_'+#id")
    public UserInfo findUser(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUserName(id + "_" + new Random().nextInt());
        log.info("service will cache user user_{}", id);
        return userInfo;
    }

    @CacheEvict(value = "userCache", key = "'user_'+#id")
    public String deleteUser(Integer id) {
        return "删除成功";
    }
}
