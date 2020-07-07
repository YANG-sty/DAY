package com.sys.DesignPatterns.AbstractFactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/7 on 9:13
 */
public class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("mysql connection ....................");
    }
}
