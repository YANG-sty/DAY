package com.sys;

import lombok.Data;

import java.util.*;

/**
 * Create by yang_zzu on 2020/7/10 on 16:04
 */
public class ListRemove {
    @Data
    static class Student{
        private String name;
        private String age;
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("小明");
        student.setAge("11");

        Student student1 = new Student();
        student1.setName("小明2");
        student1.setAge("112");

        Student student2 = new Student();
        student2.setName("小明");
        student2.setAge("11");

        Student student3 = new Student();
        student3.setName("小明1");
        student3.setAge("111");

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        Iterator<Student> iterator = list.iterator();
        Set<String> strings = new HashSet<>();
        while (iterator.hasNext()) {
            Student next = (Student) iterator.next();
            if (!strings.contains(next.getName())) {
                strings.add(next.getName());
            } else {
                iterator.remove();
            }
        }

        for (Student student4 : list) {
            System.out.println(student4);
        }


    }
}
