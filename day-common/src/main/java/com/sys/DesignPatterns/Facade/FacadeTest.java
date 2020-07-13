package com.sys.DesignPatterns.Facade;

/**
 * 门面模式（）
 * Create by yang_zzu on 2020/7/12 on 16:57
 */
public class FacadeTest {

    public static void main(String[] args) {

        // 直接调用门面方法类
        Facade facade = new Facade();
        facade.doSomething1();

        //普通的客户端
        Client1 client1 = new Client1();
        client1.doSomething1();

        //客户端使用，门面模式
        Client2 client2 = new Client2();
        client2.doSomething2();

    }

}
