package com.sys.lockTest.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangLongFei 2020-12-18-22:29
 */
public class Container2 {
    volatile List list = new ArrayList();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container2 container1 = new Container2();
        Object lock = new Object();

        /**
         * t2 线程在 t1 线程之前，
         * 保证 t2 线程在等待状态
         */
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动。。。");
                if (container1.size() != 5) {
                    try {
                        lock.wait(); //线程等待， 需要添加 syncronized 关键字
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 线程结束。。。");
                lock.notify();
            }

        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println(" t1 启动成功 .... ");
                for (int i = 0; i < 10; i++) {
                    container1.add(new Object());
                    System.out.println("add " + i);

                    if (container1.size() == 5) {
                        lock.notify(); // 不会释放锁
                        try {
                            lock.wait(); //会释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" t1 结束 .... ");
            }

        }, "t1").start();



    }


}
