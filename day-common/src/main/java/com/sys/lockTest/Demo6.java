package com.sys.lockTest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 多线程，操作共享变量
 *
 * @author yangLongFei 2020-12-18-21:37
 */
public class Demo6 {
    //volatile 保证内存可见性
    volatile int count = 0;
//    int count = 0;

    /**
     * 方式1： 添加 volatile 关键字
     * 方式2： 方法添加 syncronized ，让线程一个一个的进行执行操作
     */
    public synchronized void test() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(demo6::test, " thread = " + i));
        }

        threads.forEach((thread -> thread.start()));

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(demo6.count);
    }
}
