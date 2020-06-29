package com.sys.DesignPatterns.Singleton.Lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

/**
 * Create by yang_zzu on 2020/6/28 on 17:48
 */
public class LayzySingletonTest {
    public static void main(String[] args) throws InterruptedException {
        LazySingleton lazySingleton = LazySingleton.getLazySingleton();
        Consumer consumer = System.out::println;

        new Thread(() ->{
            try {
                //该线程睡 5 秒
                Thread.sleep(1000);
                LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
                consumer.accept(lazySingleton1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();

        new Thread(() -> {
            LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
            consumer.accept(lazySingleton1);
        }
        ).start();

        consumer.accept(lazySingleton);

        /**
         * 反射方式，实例化对象
         * 会实例化一个新的对象
         */
        try {
            Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            LazySingleton lazySingleton1 = declaredConstructor.newInstance();
            consumer.accept(lazySingleton1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
