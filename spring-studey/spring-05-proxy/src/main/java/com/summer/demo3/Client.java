package com.summer.demo3;


public class Client {
    public static void main(String[] args) {
        //真实对象
        HouseOwner rent = new HouseOwner();

        //代理角色生成工具
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(rent);

        //获取动态代理类
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
