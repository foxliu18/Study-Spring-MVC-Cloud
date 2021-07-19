package com.summer.demo4;

import com.summer.demo2.UserService;
import com.summer.demo2.UserServiceImpl;


public class Client {
    public static void main(String[] args) {

        //real role
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler();
        invocationHandler.setTarget(userService);

        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();
        proxy.delete();
    }
}