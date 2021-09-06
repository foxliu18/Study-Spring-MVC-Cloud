package com.concurrent.lockDemo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程就是一个单独的资源类，没有任何附属的操作
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        // 并发，多个线程操作同一个资源类
        Ticket1 ticket = new Ticket1();
        //@FunctionalInterface lambad表达是 (参数)->{代码}
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }

        },  "A").start();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },  "B").start();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }

}

// Lock
// 1. new lock
// 2. 加锁
// 3. 释放锁
class Ticket1{
    //属性 方法
    private int number = 50;
    Lock lock = new ReentrantLock();
    public synchronized void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+number--+"票，剩余"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
