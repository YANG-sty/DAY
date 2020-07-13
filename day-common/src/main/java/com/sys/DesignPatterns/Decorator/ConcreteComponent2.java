package com.sys.DesignPatterns.Decorator;

/**
 * Create by yang_zzu on 2020/7/12 on 20:27
 */
public class ConcreteComponent2 extends Decorator {

    public ConcreteComponent2(Component component) {
        super(component);
    }

    @Override
    public void iperation() {
        component.iperation();
        System.out.println("添加滤镜，更加优美！！！");
    }
}
