package com.kim.p2p.manager;

import com.alibaba.fastjson.JSON;
import com.kim.p2p.common.utils.RedisUtils;
import com.kim.p2p.manager.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class RedisTestor {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void setKey(){
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setRecommendPerson("周先生");
        user.setUsername("zhouxiansheng");
        user.setPassword("zxs");
        log.info("result: {}", redisUtils.set("user", user));
    }

    @Test
    void getKey(){
        Object user = redisUtils.get("user");
        log.info("user: {}", JSON.toJSONString(user));
    }
}
