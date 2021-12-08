package com.fall.shirospringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/", "/index"})
    public String toIndex(Model model){
        model.addAttribute("msg", "hello shiro");
        return "index";
    }

    @RequestMapping({"user/add"})
    public String add(Model model){
        model.addAttribute("msg", "add user");
        return "user/add";
    }

    @RequestMapping({"user/update"})
    public String update(Model model){
        model.addAttribute("msg", "update user");
        return "user/update";
    }

    @RequestMapping({"toLogin"})
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(String userName, String password, Model model){
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try{
            subject.login(token); // 执行登陆方法 无异常就正常登陆
            return "index";
        }catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权无法访问";
    }
}
