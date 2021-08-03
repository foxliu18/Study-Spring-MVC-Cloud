package com.summer.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.summer.pojo.User;
import com.summer.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController//不会走视图解析器
public class UserController {

    //@RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    @ResponseBody //不会走视图解析器,会直接返回String 配合@Controller
    public String json1() throws JsonProcessingException {
        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建对象
        User user = new User("刘科兴", 15, "male");

        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = new ArrayList<>();
        //创建对象
        User user = new User("刘科兴", 15, "male");
        User user1 = new User("刘科兴", 15, "male");
        User user2 = new User("刘科兴", 15, "male");
        User user3 = new User("刘科兴", 15, "male");
        User user4 = new User("刘科兴", 15, "male");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        String str = mapper.writeValueAsString(userList);
        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String str = mapper.writeValueAsString(simpleDateFormat.format(date));
        return str;
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {
        //jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();

        String str = JsonUtils.getJson(date, "yyyy-MM-dd HH:mm:ss");
        return str;
    }

    @RequestMapping("/j5")
    public String json5() throws JsonProcessingException {
        //jackson ObjectMapper
        List<User> userL = new ArrayList<>();
        //创建对象
        User user = new User("刘科兴", 15, "male");
        User user1 = new User("刘科兴", 15, "male");
        User user2 = new User("刘科兴", 15, "male");
        User user3 = new User("刘科兴", 15, "male");
        User user4 = new User("刘科兴", 15, "male");

        userL.add(user);
        userL.add(user1);
        userL.add(user2);
        userL.add(user3);
        userL.add(user4);

        return JSON.toJSONString(userL);
    }
}
