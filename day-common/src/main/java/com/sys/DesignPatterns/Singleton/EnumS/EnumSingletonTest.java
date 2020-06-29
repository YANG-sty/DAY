package com.sys.DesignPatterns.Singleton.EnumS;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;

/**
 * Create by yang_zzu on 2020/6/28 on 20:26
 */
public class EnumSingletonTest {
    public static void main(String[] args) {

        Consumer consumer = System.out::println;
        EnumSingleton enumSingleton = EnumSingleton.enumSingleton;
        consumer.accept(enumSingleton);
        enumSingleton.print();

        new Thread(() -> {
            EnumSingleton enumSingleton1 = EnumSingleton.enumSingleton;
            consumer.accept(enumSingleton1);
            enumSingleton1.print();
        }).start();

        new Thread(() -> {
            EnumSingleton enumSingleton1 = EnumSingleton.enumSingleton;
            consumer.accept(enumSingleton1);
            enumSingleton1.print();
        }).start();

        /**
         * 枚举类，初始化的时候不支持 getDeclaredConstructor() 该方法
         */
        try {
            Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
            declaredConstructor.setAccessible(true);
            //这里传递的参数是任意的
            EnumSingleton enumSingleton1 = declaredConstructor.newInstance("INSTANCE",0);
            consumer.accept(enumSingleton1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
