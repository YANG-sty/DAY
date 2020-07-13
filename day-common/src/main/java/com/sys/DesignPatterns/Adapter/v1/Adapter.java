package com.sys.DesignPatterns.Adapter.v1;

/**
 * 实现转换接口
 * Create by yang_zzu on 2020/7/12 on 17:44
 */
public class Adapter implements Target {

    Adaptee adaptee = new Adaptee();

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int ouput220v = adaptee.ouput220v();
        //做一些其他的操作
        System.out.println(" 在这里做了一下转换的操作。。。。。");

        return 5;
    }

}
