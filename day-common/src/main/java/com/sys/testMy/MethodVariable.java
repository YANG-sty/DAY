package com.sys.testMy;

import lombok.Data;
import org.junit.Test;

import java.io.Serializable;

/**
 * Create by yang_zzu on 2020/7/1 on 10:00
 */
public class MethodVariable {

    @Data
    static class Student implements Serializable {
        private static final long serialVersionUID = 175940226244264979L;
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

        System.out.println("------------------------");

        Student abc = studentnew;
        System.out.println(studentnew);
        System.out.println(abc);

        studentnew.setMony(1001);

        System.out.println(studentnew);
        System.out.println(abc);


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
