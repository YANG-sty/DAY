package com.sys.DesignPatterns.FactoryPatterns;

/**
 * 工厂模式
 * Create by yang_zzu on 2020/7/6 on 18:49
 */
public class FactoryMethod {

    public static void main(String[] args) {
        //简单工厂(不是真正的设计模式，只是一种解决问题的方法，不具有灵活性的特点)
        SimpleApplication application = new SimpleApplication();
        Product object = application.getObject("1");
        object.method1();

        System.out.println("----------------------------------------------");

        //简单工厂 和 工厂接口 和在一起
        SimpleFactoryDouble simpleFactoryDouble = new SimpleFactoryDouble();
        Product product = simpleFactoryDouble.createProduct("0");
        product.method1();
        Product product1 = simpleFactoryDouble.createProduct("1");
        product1.method1();

        System.out.println("----------------------------------------------");

        // 工厂模式
        ConcreteProductA concreteProductA = new ConcreteProductA();
        Product object1 = concreteProductA.getObject();
        object1.method1();
    }


}


