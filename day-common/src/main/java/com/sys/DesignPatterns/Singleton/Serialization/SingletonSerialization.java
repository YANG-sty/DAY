package com.sys.DesignPatterns.Singleton.Serialization;

import com.sys.DesignPatterns.Singleton.Lazy.LazySingleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Create by yang_zzu on 2020/6/29 on 10:08
 */
public class SingletonSerialization implements Serializable {
    private static final long serialVersionUID = -9146796727013614891L;

    private String name;
    private String age;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private volatile static SingletonSerialization singletonSerialization;

    public static SingletonSerialization getSingletonSerialization() {
        if (singletonSerialization == null) {

            synchronized (SingletonSerialization.class) {
                if (singletonSerialization == null) {
                    singletonSerialization = new SingletonSerialization();
                }
            }
        }
        return singletonSerialization;
    }

    private SingletonSerialization() {

    }

    /**
     * 序列化 和 反序列化
     * 保持为同一个对象
     *
     * 反序列化
     * 从流中读取实例时需要指定替换的类应使用带有精确签名的特殊方法来实现。
     * 指定返回的数据，不实现该方法则会从 文件流 里面获取数据，
     * 实现该方法，获取到该方法返回的数据。
     */
    Object readResolve() throws ObjectStreamException {
        return SingletonSerialization.singletonSerialization;
    }

}
