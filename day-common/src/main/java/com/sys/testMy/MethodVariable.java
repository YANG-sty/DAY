package com.sys.testMy;

import lombok.Data;
import org.junit.Test;

/**
 * Create by yang_zzu on 2020/7/1 on 10:00
 */
public class MethodVariable {

    @Data
    static class Student {
        private String name;
        private String age;
        private Integer mony;
    }

    @Test
    public static void main(String[] args) {

        Student studentold = new Student();
        studentold.setName("xiaoming");
        studentold.setAge("10");

        Student studentnew = new Student();
        studentnew.setName("小乌龟");
        studentnew.setAge("111");
        Student copy = MethodVariable.copy(studentnew, studentold);

        System.out.println(studentold);
        System.out.println(copy);

        if (copy.getMony()>0) {
            System.out.println(copy.getName());
        }

        Integer a = null;
        Integer b = 1;
        int c = b - a;

    }

    public static Student copy(Student newStudent, Student oldStudent) {
        oldStudent.setName(newStudent.getName());
        oldStudent.setAge(newStudent.getAge());
        return oldStudent;
    }

}
