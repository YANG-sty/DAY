package com.sys.DesignPatterns.FactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/6 on 19:30
 */
public class ConcreteProductA extends Application {
    @Override
    Product createProduct() {

        //.........

        return new ProductA();
    }
}
