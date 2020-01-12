package com.kim.p2p;

import com.kim.p2p.manager.controller.UserController;
import com.kim.p2p.manager.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;

@Slf4j
@SpringBootTest
class P2pTestApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setNickname("user");
        user.setUsername("user");
        user.setPassword("user123");
        user.setRecommendPerson("other one");

        BindingResult bindingResult = new DirectFieldBindingResult(user, "user");
        String a = userController.createUser(user, bindingResult);

        log.info("a: {}", a);
    }

}
