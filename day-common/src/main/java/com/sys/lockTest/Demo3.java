package com.sys.lockTest;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * 脏读 dirtyRead
 *
 * @author yangLongFei 2020-12-18-20:07
 */
public class Demo3 {


    String name;
    double balance;

    // 写 , 加锁
    public synchronized void set(String name, double balance) {
        this.name = name;

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    /**
     * 读， 不加锁，读出来的数据，会出现脏读
     * 读， 加锁， 不会出现脏读，先执行写操作，然后读，能够读出正确的数据
     */
    public synchronized double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        new Thread(() -> demo3.set("yang_zzu", 18.8)).start();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo3.getBalance("yang_zzu"));

        try {
            TimeUnit.MILLISECONDS.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo3.getBalance("yang_zzu"));
    }


}
