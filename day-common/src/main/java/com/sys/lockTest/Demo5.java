package com.sys.lockTest;

import java.util.concurrent.TimeUnit;

/**
 * @author yangLongFei 2020-12-18-20:31
 */
public class Demo5 {
    int count = 0;

    synchronized void test() {
        System.out.println(Thread.currentThread().getName() + " start ... ");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                /**
                 * 并发方法，出现异常的时候，必须要 捕获异常进行处理，
                 * 不进行异常的捕获，则会自动释放锁，从而执行其他的方法
                 */
                try {
                    int i = 1 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //int i= 1/0;
            }
        }
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        Runnable r = () -> demo5.test();
        new Thread(r, "t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r, "t2").start();
    }
}
