package com.sys.DesignPatterns.Observer;

/**
 * 观察者 1
 * Create by yang_zzu on 2020/7/13 on 16:15
 */
public class Task1 implements Observer {

    @Override
    public void update(Object object) {
        System.out.println("Task1 received: " + object);
    }

}
