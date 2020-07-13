package com.sys.DesignPatterns.Strategy.v2;


/**
 * Create by yang_zzu on 2020/7/13 on 11:01
 */
public class StrategyTest {
    public static void main(String[] args) {

        NormalZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        System.out.println("------------------------------------");

        FlagZombie flagZombie = new FlagZombie();
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
        System.out.println("修改旗手僵尸的攻击方式。。。。。。");
        flagZombie.setAttackAble(new HitAttack());
        flagZombie.attack();
    }
}
