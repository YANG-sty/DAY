package com.sys.DesignPatterns.Observer;

/**
 * Create by yang_zzu on 2020/7/13 on 16:10
 */
public class ObserverTest {
    public static void main(String[] args) {

        //主题对象
        Subject subject = new Subject();

        //观察者 1
        Task1 task1Observer = new Task1();
        subject.addObservet(task1Observer);

        //观察者 2
        Task2 task2Observer = new Task2();
        subject.addObservet(task2Observer);

        subject.notifyObservet("xxxxxxx");

        System.out.println("---------------------");

        subject.removeObservet(task1Observer);
        subject.notifyObservet("yyyyyy");

    }
}
