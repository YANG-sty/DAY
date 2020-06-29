package com.sys.DesignPatterns.Singleton.StaticS;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;

/**
 * Create by yang_zzu on 2020/6/28 on 20:12
 */
public class StaticSingletonTest {
    public static void main(String[] args) {

        Consumer consumer = System.out::println;
        StaticSingleton instance = StaticSingleton.getInstance();
        consumer.accept(instance);

        new Thread(() -> {
            StaticSingleton instance1 = StaticSingleton.getInstance();
            consumer.accept(instance1);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                StaticSingleton instance1 = StaticSingleton.getInstance();
                consumer.accept(instance1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        /**
         * 反射方式，实例化对象
         * 会实例化一个新的对象
         */
        try {
            Constructor<StaticSingleton> declaredConstructor = StaticSingleton.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            StaticSingleton staticSingleton = declaredConstructor.newInstance();
            consumer.accept(staticSingleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
