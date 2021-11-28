package com.fall.controller;

import com.fall.mapper.UserMapper;
import com.fall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }
}
