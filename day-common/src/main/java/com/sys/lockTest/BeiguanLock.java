package com.sys.lockTest;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangLongFei 2020-11-12-10:15
 */
public class BeiguanLock {

    public volatile static int anInt = 1;

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int x = 0; x < 10; x++) {
                    anInt++;
                    System.out.println(anInt);
                }
            }).start();
        }

    }

    /**
     * 悲观锁
     * ReentrantLock()
     */
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Test
    public void test11() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    reentrantLock.lock();
                    for (int x = 0; x < 10; x++) {
                        anInt++;
                        System.out.println(anInt);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }).start();
        }
    }

    /**
     * 悲观锁
     */
    @Test
    public  void test2() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int x = 0; x < 10; x++) {
                    addMethod();
                }
            }).start();
        }
    }

    public  void addMethod() {
        anInt++;
        System.out.println(anInt);
    }


    @Test
    public void test3() {
        // 需要保证多个线程使用的是同一个AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger(10);
        //执行自增1
        atomicInteger.incrementAndGet();
        int i = atomicInteger.get();
        System.out.println(i);
    }



    /**
     * 线程池
     * ThreadPoolExecutor
     */
    @Test
    public void test20() throws InterruptedException {
        /**
         * 1、corePoolSize线程池的核心线程数
         * 2、maximumPoolSize能容纳的最大线程数
         * 3、keepAliveTime空闲线程存活时间
         * 4、unit 存活的时间单位
         * 5、workQueue 存放提交但未执行任务的队列
         * 6、threadFactory 创建线程的工厂类
         * 7、handler 等待队列满后的拒绝策略
         */
        ExecutorService executor = new ThreadPoolExecutor(
                10,
                20,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int x = 0; x < 10; x++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        anInt++;
                        System.out.println(anInt);
                    }
                }
            });
        }
        if (!executor.isShutdown()) {
            executor.shutdown();
            System.err.println(anInt);
        }
    }


    class ArrayWithLockOrder {

        private long num_locks = 0;
        private long lock_order;
        private int[] arr;

        public ArrayWithLockOrder(int[] a) {
            arr = a;
            synchronized (ArrayWithLockOrder.class) {//-----------------------------------------这里
                num_locks++;             // 锁数加 1。
                lock_order = num_locks;  // 为此对象实例设置唯一的 lock_order。
            }
        }

        public long lockOrder() {
            return lock_order;
        }

        public int[] array() {
            return arr;
        }

        class SomeClass implements Runnable {
            public int sumArrays(ArrayWithLockOrder a1, ArrayWithLockOrder a2) {
                int value = 0;
                ArrayWithLockOrder first = a1;       // 保留数组引用的一个
                ArrayWithLockOrder last = a2;        // 本地副本。
                int size = a1.array().length;
                if (size == a2.array().length) {
                    if (a1.lockOrder() > a2.lockOrder())  // 确定并设置对象的锁定
                    {                                     // 顺序。
                        first = a2;
                        last = a1;
                    }
                    synchronized (first) {              // 按正确的顺序锁定对象。
                        synchronized (last) {
                            int[] arr1 = a1.array();
                            int[] arr2 = a2.array();
                            for (int i = 0; i < size; i++) {
                                value += arr1[i] + arr2[i];
                            }
                        }
                    }
                }
                return value;
            }

            @Override
            public void run() {

            }
        }


    }
}
