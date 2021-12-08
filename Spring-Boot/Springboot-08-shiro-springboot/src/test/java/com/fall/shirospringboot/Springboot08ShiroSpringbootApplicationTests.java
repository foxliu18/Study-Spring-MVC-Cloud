package com.fall.shirospringboot;

import com.fall.shirospringboot.pojo.User;
import com.fall.shirospringboot.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot08ShiroSpringbootApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        User user = userService.queryUserByName("zhang");
        System.out.println(user);
    }

}
