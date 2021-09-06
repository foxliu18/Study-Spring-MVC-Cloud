package com.concurrent.single;

import java.lang.reflect.Constructor;

public class LazyMan {
    private LazyMan(){
        // 防止反射调用无参构造器
        synchronized (LazyMan.class){
            if (lazyMan != null){
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
        }

        System.out.println(Thread.currentThread().getName() + "-ok");
    }

    // 需要volatile修饰 保证多线程可见性
    private volatile static LazyMan lazyMan;


    //单线程 没问题
    //DCL 双重检测模式 懒汉式单例
    public static LazyMan getInstance(){
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan(); // 不原子操作
                    /**
                     * 1. 分配内存空间
                     * 2. 执行构造方法
                     * 3. 把这个对象指向这个空间
                     * 指令重排
                     * 132
                     * Thread A 1->3->2
                     * Thread B    1->lazyMan != null->return lazyMan(not construct)
                     */
                }
            }
        }
        return lazyMan;
    }


    // 反射破坏双重检测 反射可以无视私有方法
    public static void main(String[] args) throws Exception {
        // LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declareConstructor = LazyMan.class.getDeclaredConstructor();
        declareConstructor.setAccessible(true);
        // 两个实例都用反射创建，可以破坏无参构造的检测
        // 解决方法，用枚举 反射newInstance Cannot reflectively create enum objects
        LazyMan instance2 = declareConstructor.newInstance();
        LazyMan instance3 = declareConstructor.newInstance();

        System.out.println(instance3);
        System.out.println(instance2);
    }


}
