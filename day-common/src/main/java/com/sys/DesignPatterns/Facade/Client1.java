package com.sys.DesignPatterns.Facade;

/**
 * 不是用 门面模式 的情况下，有多少个想访问子系统的客户端，
 * 就需要写多少个同样的 类 方法
 * Create by yang_zzu on 2020/7/12 on 16:52
 */
public class Client1 {

    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomething1() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}
