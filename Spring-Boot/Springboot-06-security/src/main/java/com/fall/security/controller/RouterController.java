package com.fall.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/toLogin"})
    public String login(){
        return "views/login";
    }

    @RequestMapping({"/level1"})
    public String level1(){
        return "views/level1";
    }
}
