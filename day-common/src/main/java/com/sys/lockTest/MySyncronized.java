package com.sys.lockTest;

import org.junit.Test;

/**
 * @author yangLongFei 2020-12-18-19:14
 */
public class MySyncronized {

    int count = 10;
    Object object = new Object();


    @Test
    public void test1() {
        //锁住的是 new Object(); 对象
        synchronized (object) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    @Test
    public void test2() {
        //锁住的是 当前类对象的实例
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    /**
     * 相当于锁住的是 当前类对象的实例
     */
    @Test
    public synchronized void test3() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }


    /***********************************************************************************************************/

    static int sum = 10;

    /**
     * 用于静态方法，锁住的是 xxxx.class
     */
    synchronized static void subtract() {
        sum--;
        System.out.println(Thread.currentThread().getName() + " count = " + sum);
    }


    /**
     * this 锁住的是 堆里面实例出来的对象
     * static 方法可以不用进行实例化直接进行调用，所以不能使用 this
     */
    public static void subtractStatic() {
        //这里不能替换成 this
        synchronized (MySyncronized.class) { // 这里锁住的是字节码文件
            sum--;
        }
    }




}
