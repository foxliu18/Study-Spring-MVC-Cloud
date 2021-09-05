package com.concurrent.productConsumer;

import javax.swing.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程按顺序执行 线程的精准通知
 * A -> B -> C -> A
 */
public class C {
    public static void main(String[] args) {
        DataC data = new DataC();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },  "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },  "C").start();
    }
}

class DataC
{

    private  int number = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    public void printA(){
        try {
            lock.lock();
            while (number != 1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>A");
            // 唤醒指定线程
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        try {
            lock.lock();
            while (number != 2){
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>B");
            // 唤醒指定线程
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void printC(){
        try {
            lock.lock();
            while (number != 3){
                //等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>C");
            // 唤醒指定线程
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
