package com.summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/h1")
    public String hello(Model model){
        model.addAttribute("msg", "Hello, SpringMVC Annotation");
        return "hello"; //视图解析器处理
    }

}
