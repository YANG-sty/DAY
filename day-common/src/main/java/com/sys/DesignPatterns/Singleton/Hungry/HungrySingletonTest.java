package com.sys.DesignPatterns.Singleton.Hungry;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;

/**
 * Create by yang_zzu on 2020/6/28 on 19:36
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        Consumer consumer = System.out::println;
        consumer.accept(instance);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                HungrySingleton instance1 = HungrySingleton.getInstance();
                consumer.accept(instance1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            HungrySingleton instance1 = HungrySingleton.getInstance();
            consumer.accept(instance1);
        }).start();

        /**
         * 反射方式，实例化对象
         * 会实例化一个新的对象
         */
        try {
            Constructor<HungrySingleton> declaredConstructor = HungrySingleton.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            HungrySingleton hungrySingleton = declaredConstructor.newInstance();
            consumer.accept(hungrySingleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
