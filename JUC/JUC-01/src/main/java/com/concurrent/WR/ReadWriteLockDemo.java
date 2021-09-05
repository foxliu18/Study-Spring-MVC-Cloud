package com.concurrent.WR;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁） 一次只能被一个线程占有
 * 共享锁（读锁） 多个线程可以同事占有
 * ReadWriteLock
 * 读-读 可以共存
 * 读-写 不能共存
 * 写-写 可以共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"", temp+"");
            },String.valueOf(i)).start();
        }

        // 读取
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }

    }

}
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁，更加细腻的控制
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // 存， 写的时候只希望只有一个线程写入
    public void put(String key, Object value){
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    // 取， 读
    public void get(String key){

        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
