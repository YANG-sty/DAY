package com.sys.DesignPatterns.Decorator;

/**
 * 测试类
 * Create by yang_zzu on 2020/7/12 on 20:25
 */
public class DecoratorTest {
    public static void main(String[] args) {

        ConcreteComponent2 concreteComponent2 = new ConcreteComponent2(new ConcreteComponent1( new ConcreteComponent()));
        concreteComponent2.iperation();

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        ConcreteComponent1 concreteComponent1 = new ConcreteComponent1(new ConcreteComponent0(new ConcreteComponent()));
        concreteComponent1.iperation();

    }
}
