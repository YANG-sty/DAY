package com.sys.lockTest;

import java.util.concurrent.TimeUnit;

/**
 * @author yangLongFei 2020-12-18-20:18
 */
public class Demo4 {
    /**
     * 一个同步方法，调用另一个同步方法，能否得到锁
     * 另一个方法，可以得到锁
     * 两个方法使用的是同一把锁，称为 “可重入锁”
     */

    synchronized void test1() {
        System.out.println("test1 start .... ");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();

    }

    synchronized void test2() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2 start ");

    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        demo4.test1();
    }
}
