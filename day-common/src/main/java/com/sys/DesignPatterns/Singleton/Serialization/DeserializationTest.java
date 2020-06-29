package com.sys.DesignPatterns.Singleton.Serialization;

import com.sys.DesignPatterns.Singleton.Lazy.LazySingleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.function.Consumer;

/**
 * 反序列化
 * Create by yang_zzu on 2020/6/28 on 21:11
 */
public class DeserializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //com.sys.DesignPatterns.Singleton.Lazy.LazySingleton@7ca48474
        /*LazySingleton lazySingleton = LazySingleton.getLazySingleton();

        System.out.println(lazySingleton);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("lazySingletonSerialization"));
        LazySingleton lazySingleton1 = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(lazySingleton1);

        System.out.println(lazySingleton == lazySingleton1);*/

        /**
         * 验证，
         * 在对 实例赋值之后， 进行序列化，反序列化，之后数据的变化情况
         *
         * com.sys.DesignPatterns.Singleton.Serialization.SingletonSerialization@66a3ffec
         * com.sys.DesignPatterns.Singleton.Serialization.SingletonSerialization@5622fdf
         * 在实例对象带有属性的时候，
         * 进行序列化、反序列化 的时候 实例是不一样的
         *
         * 因为通过构造函数进行序列化的时候，构造出来的是一个空的实例
         * 通过从文件中反序列化构造出来的是一个 java 对象，里面包含之前序列化的时候存储的数据，
         *
         * 目前还不知道是具体是什么原因造成的？？？？？？？？？
         */

        Consumer consumer = System.out::println;
        SingletonSerialization singletonSerialization = SingletonSerialization.getSingletonSerialization();

        ObjectInputStream singletonSerialization1 = new ObjectInputStream(new FileInputStream("singletonSerialization"));
        SingletonSerialization singletonSerialization2 = (SingletonSerialization) singletonSerialization1.readObject();
        consumer.accept(singletonSerialization2);
        singletonSerialization1.close();

        SingletonSerialization singletonSerialization3 = SingletonSerialization.getSingletonSerialization();


        consumer.accept(singletonSerialization);
        consumer.accept(singletonSerialization.getName() + "  "+singletonSerialization.getAge() +"  "+ singletonSerialization.getPhone());
        consumer.accept(singletonSerialization2);
        consumer.accept(singletonSerialization2.getName() + "  "+singletonSerialization2.getAge() +"  "+ singletonSerialization2.getPhone());

        consumer.accept(singletonSerialization3);

    }
}
