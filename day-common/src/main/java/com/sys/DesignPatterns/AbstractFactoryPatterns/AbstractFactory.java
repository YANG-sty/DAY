package com.sys.DesignPatterns.AbstractFactoryPatterns;

/**
 * Create by yang_zzu on 2020/7/7 on 9:16
 */
public class AbstractFactory {

    public static void main(String[] args) {
        MysqlDatabaseUtils mysqlDatabaseUtils = new MysqlDatabaseUtils();
        IConnection connection = mysqlDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = mysqlDatabaseUtils.getCommand();
        command.command();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        OracleDatabaseUtils oracleDatabaseUtils = new OracleDatabaseUtils();
        IConnection connection1 = oracleDatabaseUtils.getConnection();
        connection1.connect();
        ICommand command1 = oracleDatabaseUtils.getCommand();
        command1.command();

    }
}
