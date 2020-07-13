package com.sys.DesignPatterns.Adapter.v1;

/**
 * 适配器模式
 * Create by yang_zzu on 2020/7/12 on 17:47
 */
public class AdapterTest {
    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        // 初始化转换方法, Adapter 实现了 Target 中的适配器（转换）方法
        Target target = new Adapter(adaptee);
        //调用 target 接口中的转换方法，实际调用的是 Adapter 中实现的 方法
        int i = target.output5v();
        System.out.println(i);

    }
}
