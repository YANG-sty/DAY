package com.sys.DesignPatterns.Strategy.v3;

import java.util.Comparator;

/**
 * 策略一， 根据年龄排序
 * Create by yang_zzu on 2020/7/13 on 11:49
 */
public class SortByHeight implements Comparator<Person> {
    @Override
    public int compare(Person person, Person person1) {
        if (person.getHeight() > person1.getHeight()) {
            return 1;
        } else if (person.getHeight() < person1.getHeight()) {
            return -1;
        }
        return 0;
    }
}
