package com.sys.DesignPatterns.Facade;

/**
 * 门面方法，定义一组高层接口
 * 这里调用的是方法，实际应用中，应该是一系列的接口
 * Create by yang_zzu on 2020/7/12 on 16:55
 */
public class Facade {
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething1() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}
