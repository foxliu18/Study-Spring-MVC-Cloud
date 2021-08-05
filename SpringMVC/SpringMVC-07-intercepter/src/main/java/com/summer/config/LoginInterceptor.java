package com.summer.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //判断已登录，放行
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }

        if(request.getRequestURI().contains("login")){
            System.out.println("login");
            return true;
        }

        if(session.getAttribute("userLoginInfo") != null){
            return true;
        }

        //判断没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        return false;
    }
}
