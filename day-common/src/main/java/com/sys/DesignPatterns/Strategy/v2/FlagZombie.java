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
     */
    public FlagZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

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
