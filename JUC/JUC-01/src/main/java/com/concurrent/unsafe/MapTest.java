package com.concurrent.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        // map是new HashMap<>()这样用的吗
        // 不是，默认等价与 new HashMap<>(16, 0.75f);
        // int initialCapacity:初始容量 float loadFactor：加载银子
        // Map<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 1; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
                },String.valueOf(i)).start();
        }
    }
}
