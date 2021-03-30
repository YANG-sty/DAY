package com.sys.testMy.duixiang;

import lombok.Data;
import org.junit.Test;
import org.thymeleaf.expression.Arrays;

import java.io.Serializable;
import java.util.*;

/**
 * Create by yang_zzu on 2020/9/15 on 11:26
 */
public class EntityStudent {

    @Data
    static class Student implements Serializable {
        private static final long serialVersionUID = 175940226244264979L;
        private String name;
        private String age;
        private Integer mony;
    }


    @Test
    public void test1() {
        Student student = new Student();
        student.setName("xiaoming");
        System.out.println(student.toString());
        student = new Student();
        student.setAge("10");
        System.out.println(student.toString());
    }

    @Test
    public void test2() {
        Student student = new Student();
        String name = String.valueOf(student.getName());
        System.out.println(name);

        Student student1 = new Student();
        System.out.println(student == student1);

    }


    @Test
    public void test3() {
        String a ;
        Student student = new Student();
//        student.setAge(a);

//        System.out.println(a);

    }



    @Test
    public void test4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
            arrayList.remove(0);
        }
    }

    @Test
    public void test5() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            arrayList.remove(0);
        }
    }



}
