package com.fall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            Model model, HttpSession session
    ){
        if(!StringUtils.isEmpty(userName) && "123456".equals(password)){
            session.setAttribute("loginUser", userName);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "用户密码错误");
            return "index";
        }
    }
}
