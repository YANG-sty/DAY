package com.sys.DesignPatterns.TemplateMethod;

/**
 * Create by yang_zzu on 2020/7/13 on 14:59
 */
public class SubClass extends AbstractClass {

    @Override
    protected void templateMethod() {
        System.out.println("SubClass executed .........");
    }
}
