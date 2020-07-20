package com.sys.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 * Create by yang_zzu on 2020/7/13 on 16:10
 */
public class Subject {
    //容器
    List<Observer> container = new ArrayList<>();

    //add
    public void addObservet(Observer observer) {
        container.add(observer);
    }

    //remove
    public void removeObservet(Observer observer) {
        container.remove(observer);
    }

    //通知所有依赖者
    public void notifyObservet(Object object) {
        for (Observer observer1 : container) {
            observer1.update(object);
        }
    }

}
