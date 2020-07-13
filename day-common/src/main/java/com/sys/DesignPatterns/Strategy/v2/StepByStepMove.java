package com.sys.DesignPatterns.Strategy.v2;

/**
 * 实现 移动方式的 接口
 * Create by yang_zzu on 2020/7/13 on 11:08
 */
public class StepByStepMove implements MoveAble {
    @Override
    public void move() {
        System.out.println("一步一步蹦蹦蹦。。。。。。");
    }
}
