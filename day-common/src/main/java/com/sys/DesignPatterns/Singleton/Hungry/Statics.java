package com.sys.DesignPatterns.Singleton.Hungry;

/**
 * Create by yang_zzu on 2020/6/28 on 19:42
 */
public class Statics {
    //静态变量
    public static String name = "yang_zzu";

    //静态代码块
    static{
        System.out.println("static { yang_zzu }");
    }

    public static void info() {
        System.out.println(" info !!!!!!");
    }

}
