package com.sys.testMy.duixiang;

import lombok.Data;
import org.junit.Test;

import java.io.Serializable;

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
}
