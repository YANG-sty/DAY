package com.sys.DesignPatterns.FactoryPatterns;

/**
 *
 * Create by yang_zzu on 2020/7/6 on 18:50
 */
abstract class Application {

    /**
     * 每个具体工厂类只能创建一个具体产品类的实例。
     *
     * 当然也可以在该类中，创建多个方法，这样就能达到“抽象工厂模式” 的功能
     */

    //工厂方法，将该方法的实现延迟到子类
    abstract Product createProduct();

    // getObject 这部分是不变的
    Product getObject() {

        Product product = createProduct();

        //.......
        return product;
    }

}
