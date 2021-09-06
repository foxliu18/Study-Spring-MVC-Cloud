package com.concurrent.pool;

import java.util.concurrent.*;
import java.util.function.Function;

// Executors 工具类：三大方法
// 使用线程池来创建线程
/*
ThreadPoolExecutor.AbortPolicy, // 不处理抛出异常
ThreadPoolExecutor.CallerRunsPolicy, // 返回调用的线程处理
ThreadPoolExecutor.DiscardOldestPolicy, 尝试和最早的竞争 失败被忽略，不抛出异常
ThreadPoolExecutor.DiscardPolicy // 丢掉任务不抛出异常
*/
public class Demo1 {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 创建一个固定的线程池大小
//        ExecutorService threadPool = Executors.newCachedThreadPool(); // 可伸缩的

        /**
         * 最大线程如何定义
         * 1、 CPU 密集型， 几核就是几个最大线程，可以保证CPU效率最高 Runtime.getRuntime().availableProcessors()
         * 2、 IO 密集型 大于判断你的程序中十分耗IO的线程
         *    程序 15 个大型任务， IO十分占资源
         */
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy() // 阻塞队列，最大线程池都满了，后来的任务不处理
        );

        try {
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
