package com.sys.DesignPatterns.Decorator;

/**
 * Create by yang_zzu on 2020/7/12 on 20:27
 */
public class ConcreteComponent0 extends Decorator {

    //用于获得父类实现的 component 中的 iperation 方法
    public ConcreteComponent0(Component component) {
        super(component);
    }

    @Override
    public void iperation() {
        //执行 父类的方法，放到这里，先执行最里层的方法，
        component.iperation();
        System.out.println("开始添加附加功能@@@@@@@@@");

        //放到这里，先执行最外层的方法。
//        component.iperation();

    }
}
