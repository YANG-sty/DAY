package com.sys.DesignPatterns.Decorator;

/**
 * 因为是抽象类需使用 implements 可以不实现接口
 * 用于被其他类继承，然后获得 Component 的属性
 * Create by yang_zzu on 2020/7/12 on 20:23
 */
public abstract class Decorator implements Component {

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

}
