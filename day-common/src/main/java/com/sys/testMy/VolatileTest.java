package com.sys.testMy;

import org.junit.Test;

/**
 * volatile 测试类
 *
 * @author y_zzu 2020-07-29-16:20
 */
public class VolatileTest {
    public static volatile int found = 0;

    public static void main(String[] args) {

        VolatileTest volatileTest = new VolatileTest();
        int found = volatileTest.found;

        new Thread(() -> {
            System.out.println("等待基友送笔来。。。。。");
            while (VolatileTest.found == 0) {
            }
            System.out.println("笔来了，开始写字。。。。。");
        }
        ).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("基友找到笔了，送过去。。。。。");
            VolatileTest.found = 1;
        }).start();
    }

    /*public volatile int number = 0;

    public synchronized void add() {
        number++;
    }

    @Test
    public void test1() {
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(() -> {
                for (int x = 0; x < 10000; x++) {
                    add();
                    found++;
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);
        System.out.println(found);
    }

    class synchronizedTest implements Runnable {
        //共享资源
        int i =0;
        *//**
         * synchronized 修饰实例方法
         *//*
        public synchronized void increase(){
            i++;
        }
        @Override
        public void run(){
            for (int j =0 ; j<10000;j++){
                increase();
            }
        }
    }

    @Test
    public void main1() throws InterruptedException {
        synchronizedTest test = new synchronizedTest();
        for (int j = 0; j < 200; j++) {
            Thread thread = new Thread(test);
            thread.start();
            thread.join();
        }
        System.out.println(test.i);
    }*/


}
