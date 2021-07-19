package com.summer.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnotationPointcut {
    @Before("execution(* com.summer.service.UserServiceImpl.* (..))")
    public void before(){
        System.out.println("=======方法执行前=======");
    }

    @AfterReturning("execution(* com.summer.service.UserServiceImpl.* (..))")
    public void after(){
        System.out.println("=======方法执行后=======");
    }

    @Around("execution(* com.summer.service.UserServiceImpl.* (..))")
    public void around(ProceedingJoinPoint pj) throws Throwable {
        Signature signature = pj.getSignature();
        System.out.println(signature);
        System.out.println("=======方法执行Around前=======");

        Object ob = pj.proceed();

        System.out.println("=======方法执行Around后=======");
    }
}
