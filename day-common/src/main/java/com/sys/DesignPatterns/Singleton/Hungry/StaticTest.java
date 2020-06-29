package com.sys.DesignPatterns.Singleton.Hungry;

/**
 * Create by yang_zzu on 2020/6/28 on 19:44
 */
public class StaticTest {
    public static void main(String[] args) {
        /**
         * 静态代码块 在实例化的时候会进行加载
         * 静态变量，在实例化的时候会进行赋值
         *
         * 后面即使再次进行实例化，静态代码块，静态变量是不会再次加载的
         */

        Statics aStaticc = new Statics();
        System.out.println(aStaticc);
        System.out.println("---------------------");

        Statics.info(); //首次主动使用进行初始化
        System.out.println("---------------------");
        Statics.info(); //不会再去初始化

        System.out.println("---------------------");
        Statics aStatics = new Statics();
        System.out.println(aStatics.name);
        System.out.println(aStatics);

    }
}
