package com.sys.DesignPatterns.FactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/6 on 18:50
 */
public class SimpleApplication {

    private Product createProduct(String type) {

        //这里进行一系列的操作  init........

        //简单工厂进行调用(这是解决这种问题的方式，不是设计模式)
        return SimpleFactory.createProduct(type);

    }

    Product getObject(String type) {

        Product product = createProduct(type);

        //.......

        return product;
    }

}
