package com.sys.DesignPatterns.AbstractFactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/7 on 9:12
 */
public class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("mysql command !!!!!");
    }
}
