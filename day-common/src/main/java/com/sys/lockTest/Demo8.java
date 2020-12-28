package com.sys.lockTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangLongFei 2020-12-18-22:06
 */
public class Demo8 {

    /**
     * AtomicInteger 保证原子性
     *
     * 多个原子操作，不保证原子性
     *
     */
    AtomicInteger count = new AtomicInteger(0);

    public  void test() {
        for (int i = 0; i < 1000; i++) {
//            count.incrementAndGet();// count++
            if (count.get() < 500) { // get 获取数据，是一个原子操作
                count.incrementAndGet(); // incrementAndGet 自增，是一个原子操作
            }
        }
    }
    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(demo8::test, " thread = " + i));
        }

        threads.forEach((thread -> thread.start()));

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(demo8.count);
    }
}
