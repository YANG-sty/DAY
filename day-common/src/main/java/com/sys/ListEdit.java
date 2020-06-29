package com.sys;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create by yang_zzu on 2020/6/15 on 19:41
 */
public class ListEdit {
    @Data
    static class Student{
        private String id;
        private String name;
        private Integer age;
    }

    @Data
    static class Project {
        private String yuwen;
        private String shuxue;
        private String yingyu;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10);
        student.setId(UUID.randomUUID().toString());
        
        Student student1 = new Student();
        student1.setAge(101);
        student1.setId(UUID.randomUUID().toString());
        
        Student student2 = new Student();
        student2.setAge(1011);
        student2.setId(UUID.randomUUID().toString());
        
        Student student3 = new Student();
        student3.setAge(10111);
        student3.setId(UUID.randomUUID().toString());

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        for (Student student4 : students) {
            student4.setName("小乌龟");
        }

        String s = students.get(2).toString();

        System.out.println(s);
    }
}
