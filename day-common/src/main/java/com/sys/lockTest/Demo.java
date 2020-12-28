package com.sys.lockTest;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @author yangLongFei 2020-12-18-10:17
 */
public class Demo implements Runnable {
    static int count = 0;

    static TestLockClass testLockClass = new TestLockClass();

    /**
     * synchronized 锁的是代码块，堆内的实例对象 new TestLockClass();
     */
    //方式 1
    /*@Override
    public void run() {
        synchronized (testLockClass) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    //方式 2
    /*@Override
    public synchronized void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    //方式 3
   /* @Override
    public void run() {
        synchronized (this) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    //没有加锁的情况, 会导致出现重复的数据
    @Override
    public void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   /* @Test
    public void test() {
        Demo demo = new Demo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo, "Thread: " + i).start();
        }
    }*/

    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo, "Thread: " + i).start();
        }
    }


    /**
     * 打印出 锁对象头的信息
     */
    /*@Test
    public void test1() {
        synchronized (testLockClass) {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(System.getProperties());
            System.out.println(ClassLayout.parseInstance(testLockClass).toPrintable());
        }


    }*/


    /*public static void countHash(Object object) throws Exception {
        Field field = Unsafe.class.getDeclaredField("testLockClass");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        long hashCode = 0;
        for (long index = 7; index > 0; index--) {
            //
            hashCode = hashCode | (unsafe.getByte(object, index) & 0xFF) << ((index - 1) * 8);
        }
        String code = Long.toHexString(hashCode);
        System.out.println("util ----------0x : " + code);

    }*/


}
