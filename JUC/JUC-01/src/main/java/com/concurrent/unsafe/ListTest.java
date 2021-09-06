package com.concurrent.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//java.util.ConcurrentModificationException 并发修改异常
public class ListTest {
    public static void main(String[] args) {
        // 并发ArrayList 不安全
        // List<String> list = new ArrayList<>();
        /**
         * 解决方案
         * 1. 换成安全的容器 new Vector()
         * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3. List<String> list = new CopyOnWriteArrayList<>();
         */

        // copyOnWrite 写入时复制， COW策略
        // 多个线程调用list的时候， 读取的时候，固定的，写入（可能出现覆盖才做）
        // 在写入的时候避免覆盖造成数据问题
        // 读写分离
        // CopyOnWriteArrayList 没有使用synchronized，
        // 效率比使用synchronized的Vector效率高
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 50; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
