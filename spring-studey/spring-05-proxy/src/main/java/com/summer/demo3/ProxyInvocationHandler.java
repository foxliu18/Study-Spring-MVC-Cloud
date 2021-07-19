package com.summer.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类来生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    /**
     *      Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
     *                                           new Class<?>[] { Foo.class },
     *                                           handler);
     */


    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //Generate Proxy Class
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        seeHouse();
        //动态代理的本质就是使用反射机制实现
        Object result = method.invoke(rent);
        fare();
        return result;
    }

    public void seeHouse(){
        System.out.println("中介带看房");
    }

    public void fare(){
        System.out.println("中介收中介费");
    }
}
