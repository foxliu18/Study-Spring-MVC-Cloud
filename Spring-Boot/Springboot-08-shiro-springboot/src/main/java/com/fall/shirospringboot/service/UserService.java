package com.fall.shirospringboot.service;

import com.fall.shirospringboot.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User queryUserByName(String name);
}
