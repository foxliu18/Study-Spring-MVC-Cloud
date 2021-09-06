package com.concurrent.BQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // Collection
        // List
        // Set
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1(){
        // 对列大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println("===============");
        //  抛出异常 Queue full
        // System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // 抛出异常 NoSuchElementException
        System.out.println(blockingQueue.remove());
    }

    public static void test2(){
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        System.out.println(blockingQueue.offer("D")); //false 不抛出异常

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());// null 不抛出异常

    }

    /**
     * 等待 阻塞 （一直阻塞）
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // blockingQueue.put("d"); 超过容量，会一直等待
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take()); // 没有元素 一直等待

    }
    /**
     * 等待 阻塞 （超时退出）
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d", 2, TimeUnit.SECONDS); // 等待2秒退出

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        blockingQueue.poll(2, TimeUnit.SECONDS);


    }
}
