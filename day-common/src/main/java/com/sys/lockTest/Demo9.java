package com.sys.lockTest;

/**
 * @author yangLongFei 2020-12-18-22:13
 */
public class Demo9 {

    int count = 0;

    /**
     * 粗粒度的锁
     */
    public synchronized void test1() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void  test2() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 细粒度的锁
         */
        synchronized (this) {
            count++;
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
