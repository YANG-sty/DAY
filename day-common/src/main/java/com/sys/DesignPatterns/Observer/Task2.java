package com.sys.DesignPatterns.Observer;

/**
 * 观察者二：
 * Create by yang_zzu on 2020/7/13 on 16:15
 */
public class Task2 implements Observer {
    @Override
    public void update(Object object) {
        System.out.println("Task2 received: " + object);
    }
}
