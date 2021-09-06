package com.concurrent.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/** 直接使用Set<String> set = new HashSet<String>();
 * 会报错：ConcurrentModificationException
 *  1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
 *  2. Set<String> set = new CopyOnWriteArraySet<>();
  */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i < 50; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
