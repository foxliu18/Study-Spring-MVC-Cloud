package com.concurrent.utlis;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6，必须要执行任务的时候再使用
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Go out");
                countDownLatch.countDown(); // 数量-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();

        System.out.println("close door");
    }
}
