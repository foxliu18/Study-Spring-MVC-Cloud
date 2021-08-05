package com.summer.controller;

import com.summer.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.type.ArrayType;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t3")
    public String t3(String name, String password){
        String msg = "";
        if("admin".equals(name)){
            msg = "OK";
        }else{
            msg = "user not exist";
        }
        if("1234".equals(password)){
            msg = "OK";
        }else{
            msg = "wrong password";
        }
        return msg;
    }

    @RequestMapping("/t1")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void test2(String name, HttpServletResponse response) throws IOException {
        System.out.println(name);
        if("fox".equals(name)){
            response.getWriter().println(true);
        }else{
            response.getWriter().println(false);
        }
    }

    @RequestMapping("/t2")
    public List<User> t2(){
        List<User> userList = new ArrayList<>();

        userList.add(new User("fox", 52, "male"));
        userList.add(new User("前端", 18, "female"));
        return userList;
    }
}
