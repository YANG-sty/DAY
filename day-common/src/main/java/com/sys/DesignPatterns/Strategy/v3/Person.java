package com.sys.DesignPatterns.Strategy.v3;

/**
 * Create by yang_zzu on 2020/7/13 on 11:44
 */
public class Person {

    public Person(int age, double height) {
        this.age = age;
        this.height = height;
    }

    private int age;
    private double height;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
