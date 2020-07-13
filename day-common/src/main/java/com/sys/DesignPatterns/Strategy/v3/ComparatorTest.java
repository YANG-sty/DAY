package com.sys.DesignPatterns.Strategy.v3;

import java.util.Arrays;

/**
 * Create by yang_zzu on 2020/7/13 on 11:43
 */
public class ComparatorTest {

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person(10,103),new Person(8,113),new Person(12,135),};

        Arrays.sort(people, new SortByAge());
        print(people);

        System.out.println("-----------------------------");

        Arrays.sort(people, new SortByHeight());
        print(people);

    }

    static void print(Person[] array) {
        for (Person person : array) {
            System.out.println(person.toString());
        }
    }

}
