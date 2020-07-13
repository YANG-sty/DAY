package com.sys.DesignPatterns.Decorator;

/**
 * Create by yang_zzu on 2020/7/12 on 20:27
 */
public class ConcreteComponent1 extends Decorator {

    public ConcreteComponent1(Component component) {
        super(component);
    }

    @Override
    public void iperation() {
        component.iperation();
        System.out.println("美颜，好看.........");
    }
}
