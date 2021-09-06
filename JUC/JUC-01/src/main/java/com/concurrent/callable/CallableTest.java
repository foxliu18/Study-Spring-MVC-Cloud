package com.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new Runnable()).start()
        // new Thread(new FutureTask<V>)).start()
        // new Thread(new FutureTask<V>((Callable)).start()
        MyThread myThread = new MyThread();
        FutureTask<String> futureTask = new FutureTask<String>(myThread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        String str = (String) futureTask.get();
        System.out.println(str);
    }
}
class MyThread implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"=>call()");
        return Thread.currentThread().getName()+"=>1234";
    }
}