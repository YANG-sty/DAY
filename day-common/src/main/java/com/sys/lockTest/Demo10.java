package com.sys.lockTest;

import sun.java2d.loops.GraphicsPrimitive;

/**
 * @author yangLongFei 2020-12-18-22:17
 */
public class Demo10 {
    Object object = new Object();

    public void  test() {
        synchronized (object) {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Demo10 demo10 = new Demo10();
        new Thread(demo10::test, "t1").start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(demo10::test, "t2");
        /**
         * object 发生了改变，则锁定的对象也会发生改变，为了避免对象发生改变，可以使用单例模式
         */
//        demo10.object = new Object();

        // t2 不能被执行
        t2.start();

    }
}
