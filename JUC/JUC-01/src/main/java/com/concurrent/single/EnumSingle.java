package com.concurrent.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 枚举本身也是一个class类
public enum
EnumSingle {

    INSTANCE;

    // JVM保证此处只被调用一次
    EnumSingle(){
        System.out.println("init");
    }

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumSingle instance = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;

        System.out.println(instance);
        System.out.println(instance2);

        // 尝试无参构造反射破坏枚举单例
        // 报错 com.concurrent.single.EnumSingle.<init>() 没有无参构造器
        // 反编译源码可知，枚举类只有一个两参数的构造方法
        Constructor<EnumSingle> declareConstructor = EnumSingle.class.getDeclaredConstructor();
        declareConstructor.setAccessible(true);

        EnumSingle instance3 = declareConstructor.newInstance();
        EnumSingle instance4 = declareConstructor.newInstance();

        System.out.println(instance3);
        System.out.println(instance4);
    }
}
