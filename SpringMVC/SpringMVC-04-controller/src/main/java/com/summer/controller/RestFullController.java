package com.summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestFullController {

    //原来的: http://localhost:8080/add?a=1&b=2
    //RestFull: http://localhost:8080/add/a/d

    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "结果为1："+res);
        return  "test";
    }

    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "结果为2："+res);
        return  "redirect:/index.jsp";
    }

}
