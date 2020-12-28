package com.sys.lockTest;

/**
 * @author yangLongFei 2020-12-18-21:44
 */
public class Demo7 {

    /**
     * volatile 保证内存可见性
     *
     * 线程通信：
     * 1. 内存共享
     * 2. 发送消息
     */
    volatile boolean running = true;

    public void test() {
        System.out.println("test start ... ");
        while (running) {
            /**
             * 通过使用cpu打印内容，让 cpu 产生空闲时间，进行强制刷新
             * 让 cpu 进行强制刷新，（ CPU 的一致性 ，强制刷新所有核心中的数据 ）
             * 这个时候，不使用 volatile 关键字，也能保证可见性
             */
//            System.out.println(" wait ");
        }
        System.out.println("test end ...");
    }

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        new Thread(demo7::test, "t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demo7.running = false;
    }


}
