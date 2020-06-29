package com.sys.DesignPatterns.Singleton.Serialization;

import com.sys.DesignPatterns.Singleton.Lazy.LazySingleton;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.function.Consumer;

/**
 * 序列化
 * Create by yang_zzu on 2020/6/28 on 20:41
 */
public class SerializationTest {

    public static void main(String[] args) throws IOException {

        /*LazySingleton lazySingleton = LazySingleton.getLazySingleton();

        System.out.println(lazySingleton);

        ObjectOutputStream lazySingletonSerialization = new ObjectOutputStream(new FileOutputStream("lazySingletonSerialization"));
        lazySingletonSerialization.writeObject(lazySingleton);
        lazySingletonSerialization.close();*/




        Consumer consumer = System.out::println;

        SingletonSerialization singletonSerialization = SingletonSerialization.getSingletonSerialization();
        singletonSerialization.setName("哈哈");
        singletonSerialization.setAge("18");
        singletonSerialization.setPhone("13322221111");

        ObjectOutputStream singletonSerialization1 = new ObjectOutputStream(new FileOutputStream("singletonSerialization"));
        singletonSerialization1.writeObject(singletonSerialization);
        singletonSerialization1.close();

        consumer.accept(singletonSerialization);



    }
}
