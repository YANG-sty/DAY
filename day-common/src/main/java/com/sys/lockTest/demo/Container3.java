package com.sys.lockTest.demo;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yangLongFei 2020-12-18-22:29
 */
public class Container3 {
    volatile List list = new ArrayList();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container3 container1 = new Container3();
        // 门阀，发令枪，计数器
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2启动。。。");
            if (container1.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 线程结束。。。");
        }, "t2").start();

        new Thread(() -> {
                System.out.println(" t1 启动成功 .... ");
                for (int i = 0; i < 10; i++) {
                    container1.add(new Object());
                    System.out.println("add " + i);

                    if (container1.size() == 5) {
                        latch.countDown();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" t1 结束 .... ");

        }, "t1").start();


    }


}
