package com.sys.lockTest.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangLongFei 2020-12-18-22:29
 */
public class Container1 {
    /**
     * 添加 volatile 可以执行 线程2 ，但是无法正常的终止程序
     */
    volatile List list = new ArrayList();

    public void add(Object object) {
        list.add(object);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container1 container1 = new Container1();
        new Thread(() -> {
            System.out.println(" t1 线程开始 ");
            for (int i = 0; i < 10; i++) {
                container1.add(new Object());
                System.out.println("add " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(" t1 线程结束 ");
        }, "t1").start();

        new Thread(() -> {
            System.out.println("t2 线程开始。。。");
            while (true) {
                if (container1.size() == 6) {
                    break;
                }
            }
            System.out.println("t2 线程结束。。。");
        }, "t2").start();

    }


}
