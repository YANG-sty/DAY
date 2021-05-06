package com.sys.DesignPatterns.Singleton.Serialization;

import java.io.*;
import java.util.function.Consumer;

/**
 * 反序列化
 * Create by yang_zzu on 2020/6/28 on 21:11
 */
public class SerialDeserializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /**
         * 序列化 反序列化 手动获得单例，在一个 Java 进程里面
         * 这个时候， 序列化对象不实现 readResolve() 方法，则序列化的时候，会新产生一个对象
         *
         * isInstantiable：如果一个serializable/externalizable的类可以在运行时被实例化，那么该方法就返回true
         * desc.newInstance：该方法通过 反射的方式 调用无参构造方法新建一个对象。
         */

        Consumer consumer = System.out::println;

        SingletonSerialization singletonSerialization0 = SingletonSerialization.getSingletonSerialization();
        singletonSerialization0.setName("哈哈");
        singletonSerialization0.setAge("18");
        singletonSerialization0.setPhone("13322221111");
        ObjectOutputStream singletonSerialization01 = new ObjectOutputStream(new FileOutputStream("singletonSerialization"));
        singletonSerialization01.writeObject(singletonSerialization0);
        singletonSerialization01.close();
        consumer.accept("序列化： "+ singletonSerialization0);

        // --------------------------------------------
        SingletonSerialization singletonSerialization = SingletonSerialization.getSingletonSerialization();
        consumer.accept("单例方法： "+singletonSerialization.getName() + "  "+singletonSerialization.getAge() +"  "+ singletonSerialization.getPhone());
        consumer.accept("单例方法： "+singletonSerialization);

        ObjectInputStream singletonSerialization1 = new ObjectInputStream(new FileInputStream("singletonSerialization"));
        SingletonSerialization singletonSerialization2 = (SingletonSerialization) singletonSerialization1.readObject();
        consumer.accept("反序列化： "+singletonSerialization2);
        singletonSerialization1.close();


        SingletonSerialization singletonSerialization3 = SingletonSerialization.getSingletonSerialization();
        consumer.accept("单例方法： "+singletonSerialization2.getName() + "  "+singletonSerialization2.getAge() +"  "+ singletonSerialization2.getPhone());
        consumer.accept("单例方法： "+singletonSerialization3);

    }
}