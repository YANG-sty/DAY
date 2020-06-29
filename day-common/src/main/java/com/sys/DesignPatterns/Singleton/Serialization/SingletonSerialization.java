package com.sys.DesignPatterns.Singleton.Serialization;

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
}
