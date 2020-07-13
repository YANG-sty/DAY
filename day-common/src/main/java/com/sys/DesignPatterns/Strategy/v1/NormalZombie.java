package com.sys.DesignPatterns.Strategy.v1;

/**
 * 普通僵尸
 * Create by yang_zzu on 2020/7/13 on 9:42
 */
public class NormalZombie extends AbstractZombie {

    @Override
    public void disply() {
        System.out.println("我是普通僵尸。。。。。。");
    }

}
