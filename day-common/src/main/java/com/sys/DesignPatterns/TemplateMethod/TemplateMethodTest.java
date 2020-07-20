package com.sys.DesignPatterns.TemplateMethod;

/**
 * 模板方法
 * Create by yang_zzu on 2020/7/13 on 15:00
 */
public class TemplateMethodTest {
    public static void main(String[] args) {

        AbstractClass abstractClass = new SubClass();
        abstractClass.iperation();

        System.out.println("----------------------------------");

        AbstractClass abstractClass1 = new SubClass1();
        abstractClass1.iperation();

    }
}
