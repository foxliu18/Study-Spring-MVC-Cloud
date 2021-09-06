package com.concurrent.single;

public class Hungry {

    //饿汉式，浪费资源
    private Hungry(){

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return  HUNGRY;
    }
}
