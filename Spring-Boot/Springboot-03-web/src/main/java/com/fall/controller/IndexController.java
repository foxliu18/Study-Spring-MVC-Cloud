package com.fall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 在template目录下页面只能通过controller操作
// 需要模板引擎的支持
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg", "hello");
        return "test";
    }
}
