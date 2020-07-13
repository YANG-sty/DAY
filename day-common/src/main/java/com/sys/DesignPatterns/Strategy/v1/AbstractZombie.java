package com.sys.DesignPatterns.Strategy.v1;

/**
 * 定义策略抽象类，
 * 其他的僵尸，都是该类的子类
 * Create by yang_zzu on 2020/7/13 on 9:40
 */
public abstract class AbstractZombie {

    public abstract void disply();

    public void attacke() {
        System.out.println("我咬。。。。");
    }

    public void move() {
        System.out.println("一步一步蹦蹦蹦。。。。。。");
    }
}
