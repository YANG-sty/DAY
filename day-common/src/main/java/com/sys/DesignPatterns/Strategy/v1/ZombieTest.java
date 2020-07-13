package com.sys.DesignPatterns.Strategy.v1;

/**
 * 策略模式
 * Create by yang_zzu on 2020/7/13 on 9:40
 */
public class ZombieTest {

    public static void main(String[] args) {

        NormalZombie normalZombie = new NormalZombie();
        normalZombie.disply();
        normalZombie.move();
        normalZombie.attacke();

        System.out.println("---------------------------");

        FlagZombie flagZombie = new FlagZombie();
        flagZombie.disply();
        flagZombie.move();
        flagZombie.attacke();

        System.out.println("---------------------------");

        BigHeadZombie bigHeadZombie = new BigHeadZombie();
        bigHeadZombie.disply();
        bigHeadZombie.move();
        bigHeadZombie.attacke();

    }
}
