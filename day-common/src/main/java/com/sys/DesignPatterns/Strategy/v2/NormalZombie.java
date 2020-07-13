package com.sys.DesignPatterns.Strategy.v2;

/**
 * 普通僵尸
 * Create by yang_zzu on 2020/7/13 on 11:05
 */
public class NormalZombie extends Zombie {

    /**
     * 对象创建的时候，初始化，
     * 移动方式， 一步一步走
     * 攻击方式   咬
     */
    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public NormalZombie(MoveAble moveAble, AttackAble attackAble) {
        super(moveAble, attackAble);
    }

    @Override
    public void display() {
        //每个僵尸独有的内容
        System.out.println("我是普通僵尸。。。。。");
    }

    @Override
    public void move() {
        //这里使用的是父类的 moveAble
        moveAble.move();
    }

    @Override
    public void attack() {
        //使用福父类中定义的 attackAble
        attackAble.attack();
    }
}
