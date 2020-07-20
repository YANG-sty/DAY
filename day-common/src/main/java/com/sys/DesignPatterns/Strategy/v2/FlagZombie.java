package com.sys.DesignPatterns.Strategy.v2;

/**
 * 旗手僵尸
 * Create by yang_zzu on 2020/7/13 on 11:14
 */
public class FlagZombie extends Zombie {

    /**
     * 定义，初始化的时候，
     * 移动方式：一步一步
     * 攻击方式：咬
     *
     * 旗手僵尸，初始化的时候，没有进行参数的传递，
     * 定义一个 基本的 “移动方式” “攻击方式”
     */
    public FlagZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    /**
     * 也可以在初始化的时候指定，
     * “移动方式”  “攻击方式”
     */
    public FlagZombie(MoveAble moveAble, AttackAble attackAble) {
        super(moveAble, attackAble);
    }

    @Override
    public void display() {
        System.out.println("我是旗手|^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    @Override
    public void move() {
        moveAble.move();
    }

    @Override
    public void attack() {
        attackAble.attack();
    }
}
