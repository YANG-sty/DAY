package com.sys.DesignPatterns.Strategy.v2;

/**
 * 实现攻击方式的接口
 * Create by yang_zzu on 2020/7/13 on 11:12
 */
public class BiteAttack implements AttackAble {
    @Override
    public void attack() {
        System.out.println("咬。。。。。。。。。。。。。。");
    }
}
