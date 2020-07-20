package com.sys.DesignPatterns.TemplateMethod;

/**
 * 模板方法，抽象类，定义了方法
 * Create by yang_zzu on 2020/7/13 on 14:55
 */
public abstract class AbstractClass {

    public void iperation() {
        //打开链接
        //sql执行
        //关闭连接
        System.out.println("pre。。。。。。。");
        System.out.println("step_1。。。。。。。");
        System.out.println("step_2。。。。。。。");

        templateMethod();
        //。。。。。

    }

    abstract protected void templateMethod();

}
