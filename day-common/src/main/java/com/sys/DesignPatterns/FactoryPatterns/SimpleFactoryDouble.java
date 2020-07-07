package com.sys.DesignPatterns.FactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/6 on 21:13
 */
public class SimpleFactoryDouble {
    public Product createProduct(String type) {
        if ("0".equals(type)) {
            return new ProductA();
        } else if ("1".equals(type)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}
