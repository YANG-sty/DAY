package com.sys.DesignPatterns.Adapter.v2;


/**
 * Create by yang_zzu on 2020/7/12 on 17:44
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public int output5v() {
        //因为， 继承了 Adaptee，所以在 Adapter 中可以直接代用父类中的方法
        int ouput220v = ouput220v();
        //做一些其他的操作
        System.out.println("继承的方式， 在这里做了一下转换的操作。。。。。");

        return 5;
    }
}
