package com.sys.DesignPatterns.Strategy.v1;

/**
 * 大头僵尸
 * Create by yang_zzu on 2020/7/13 on 10:56
 */
public class BigHeadZombie extends AbstractZombie {
    @Override
    public void disply() {
        System.out.println("我是大头☀☀☀☀☀☀☀☀☀");
    }

    /**
     * 大头僵尸的攻击方式改变了，这里重写 父类中 attacke 的攻击方法
     */
    @Override
    public void attacke() {
        //......
        System.out.println("头撞。。。。。。。");
    }
}
