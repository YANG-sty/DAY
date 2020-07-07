package com.sys.DesignPatterns.FactoryPatterns;

/**
 * 简单工厂（不是设计模式）
 * Create by yang_zzu on 2020/7/6 on 19:06
 */
public class SimpleFactory {

    public static Product createProduct(String type) {
        if ("0".equals(type)) {
            return new ProductA();
        } else if ("1".equals(type)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}
