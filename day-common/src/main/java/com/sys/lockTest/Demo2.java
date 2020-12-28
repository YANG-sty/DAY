package com.sys.lockTest;

/**
 * @author yangLongFei 2020-12-18-20:00
 */
public class Demo2 {

    /**
     * 同步方法 和 非同步方法，可以被同时调用
     */

    public synchronized void test1() {
        System.out.println(Thread.currentThread().getName() + " test1 start .... ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " test1 end .... ");
    }

    public void test2() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " test2 ");
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2::test1, "test1").start();
        new Thread(demo2::test2, "test2").start();
    }

}
