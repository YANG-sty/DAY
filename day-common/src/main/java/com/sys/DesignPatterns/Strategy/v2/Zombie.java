package com.sys.DesignPatterns.Strategy.v2;

/**
 * 每个僵尸都要继承这个 抽象类
 * 找到不变的部分
 * 每个僵尸都具有的特征：
 * 1. 展示
 * 2. 移动方式
 * 3. 攻击方式
 *
 * 通过抽象类，将这些不变的类进行整合
 *
 * Create by yang_zzu on 2020/7/13 on 11:02
 */
public abstract class Zombie {

    public abstract void display();
    public abstract void move();
    public abstract void attack();

    MoveAble moveAble;
    AttackAble attackAble;

    public Zombie(MoveAble moveAble, AttackAble attackAble) {
        this.moveAble = moveAble;
        this.attackAble = attackAble;
    }

    public MoveAble getMoveAble() {
        return moveAble;
    }

    public void setMoveAble(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    public AttackAble getAttackAble() {
        return attackAble;
    }

    public void setAttackAble(AttackAble attackAble) {
        this.attackAble = attackAble;
    }
}
