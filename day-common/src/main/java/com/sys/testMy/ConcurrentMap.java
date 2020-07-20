package com.sys.testMy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * Create by yang_zzu on 2020/7/13 on 20:08
 */
public class ConcurrentMap {

    public static void main(String[] args) {
        //双端队列
        Map<String, String> map = new ConcurrentHashMap<String, String>();

        //高并发并且排序
        Map<String, String> map1 = new ConcurrentSkipListMap<String, String>();

        Map<String, String> map2 = new Hashtable<>();

        Map<String, String> map3 = new HashMap<String, String>();

        Random random = new Random();
        Thread[] threads = new Thread[100];

        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for(int j=0; j<10000;j++) {
                    map.put("a" + random.nextInt(100000), "a" + random.nextInt(100000));
                }
                latch.countDown();
            });
        }

        Arrays.asList(threads).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }



}
