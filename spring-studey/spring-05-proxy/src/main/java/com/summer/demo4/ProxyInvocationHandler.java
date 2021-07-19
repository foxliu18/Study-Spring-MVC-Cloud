package com.summer.demo4;


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
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //Generate Proxy Class
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }



    //handle proxy class and return result
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log(method.getName());
        //动态代理的本质就是使用反射机制实现
        Object result = method.invoke(target);

        return result;
    }

    public void log(String msg){
        System.out.println("[Debug] Invoke a method: "+msg);

    }

}
