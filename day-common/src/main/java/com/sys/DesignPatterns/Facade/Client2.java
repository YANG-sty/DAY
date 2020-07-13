package com.sys.DesignPatterns.Facade;

/**
 * Create by yang_zzu on 2020/7/12 on 16:52
 */
public class Client2 {

    /**
     * 直接调用 门面对象，不用管里面的具体调用方法
     *
     * 如果不调用门面对象，就需要像 Client1 一样，去一个一个的进行调用
     */
    Facade facade = new Facade();

    public void doSomething2() {
        facade.doSomething1();
    }
}
