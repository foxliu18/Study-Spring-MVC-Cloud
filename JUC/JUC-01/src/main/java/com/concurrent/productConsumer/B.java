package com.concurrent.productConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间通信问题，生产者和消费者问题
 * 线程交替执行 A B 操作同一个变量 num = 0
 * A num + 1
 * B num - 1
 */
public class B {
    public static void main(String[] args) {
        DataB data = new DataB();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try{
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try{
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try{
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "D").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try{
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}

class DataB
{
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    // condition.await();
    // condition.signalAll();
    // +1
    public void increment() throws InterruptedException {

        try {
            lock.lock();
            while (number != 0){
                // 等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            // 通知其他线程， 我+1完毕了
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    // -1

    public void decrement() throws InterruptedException {

        try {
            lock.lock();
            while (number == 0){
                // 等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            // 通知其他线程， 我-1完毕了
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
