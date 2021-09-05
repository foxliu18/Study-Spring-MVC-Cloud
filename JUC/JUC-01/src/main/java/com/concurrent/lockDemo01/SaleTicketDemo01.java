package com.concurrent.lockDemo01;

/**
 * 线程就是一个单独的资源类，没有任何附属的操作
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 并发，多个线程操作同一个资源类
        Ticket ticket = new Ticket();

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
// 资源类OOP
class Ticket{
    //属性 方法
    private int number = 50;

    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+number--+"票，剩余"+number);
        }
    }
}
