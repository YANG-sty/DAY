package com.sys.DesignPatterns.AbstractFactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/7 on 9:11
 */
public interface IDatabaseUtils {

    /**
     * 每个具体工厂类可以创建多个具体产品类的实例。
     */
    //产品类 1
    IConnection getConnection();

    //产品类 2
    ICommand getCommand();

}
