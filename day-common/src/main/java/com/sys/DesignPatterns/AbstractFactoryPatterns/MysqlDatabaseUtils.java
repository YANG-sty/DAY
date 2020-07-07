package com.sys.DesignPatterns.AbstractFactoryPatterns;


/**
 * Create by yang_zzu on 2020/7/7 on 9:14
 */
public class MysqlDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}
