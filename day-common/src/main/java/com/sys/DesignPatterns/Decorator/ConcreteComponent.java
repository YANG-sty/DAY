package com.sys.DesignPatterns.Decorator;

/**
 * 实现Component 接口
 * 装饰器模式，需要在该 功能的基础之上添加新的功能
 *
 * Create by yang_zzu on 2020/7/12 on 20:22
 */
public class ConcreteComponent implements Component {
    @Override
    public void iperation() {
        System.out.println(" 拍照 。。。。。");
    }
}
