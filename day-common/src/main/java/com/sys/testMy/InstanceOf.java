package com.sys.testMy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create by yang_zzu on 2020/5/27 on 15:19
 */
public class InstanceOf {
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


    static void transtation(Object object) {
        System.out.println(object.toString());

        Class<?> aClass = object.getClass();
        System.out.println(aClass);

        if (object instanceof Student) {

            /**
             * 直接进行强转是 不怎么 耗时的
             */
            long currentTimeMillis = System.currentTimeMillis();
            Student student = (Student) object;
            System.out.println("强转  " + (System.currentTimeMillis() - currentTimeMillis));
            System.out.println(student.toString());

            /**
             * 将对象转换成 JSON 数据是消耗时间的
             * 第一次装换的时候消耗的时间比较多
             * 在同一个方法中的第二次执行的时候，消耗的时间是 0
             *
             */
            long currentTime = System.currentTimeMillis();
            String s = JSONObject.toJSONString(object);
            System.out.println(s);
            Student student1 = JSONObject.parseObject(s, Student.class);
            System.out.println("JOSN  " + (System.currentTimeMillis() - currentTime));
            System.out.println(student1.toString());

            System.out.println("########################");
        }
    }

    static void JOSN(Object object) {

        if (object instanceof Project) {
            long currentTime = System.currentTimeMillis();
            String s = JSONObject.toJSONString(object);
            System.out.println(s);
            Project project = JSONObject.parseObject(s, Project.class);
            System.out.println("JOSN  " + (System.currentTimeMillis() - currentTime));
            System.out.println(project.toString());
        }

        System.out.println("---------------------------");

    }


    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        student1.setId(UUID.randomUUID().toString());
        student2.setName("xiaoming");
        student3.setAge(20);


        Project project1 = new Project();
        project1.setYuwen("语文");
        Project project2 = new Project();
        project2.setShuxue("数学");
        Project project3 = new Project();
        project3.setYingyu("英语");

        transtation(student1);
        JOSN(project1);
        transtation(student2);
        JOSN(project2);
        transtation(student3);
        JOSN(project3);


    }


    @Test
    public void test1() {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student();
        student1.setId(UUID.randomUUID().toString());
        student1.setName("xiaoming");
        student1.setAge(10);
        Student student2 = new Student();
        student2.setId(UUID.randomUUID().toString());
        student2.setName("honghong");
        student2.setAge(18);

        studentList.add(student1);
        studentList.add(student2);

        //这两中共将 list 集合转为字符串，没有任何区别
        String s = JSONObject.toJSONString(studentList);
        System.out.println(s);
        String s1 = JSONArray.toJSONString(studentList);
        System.out.println(s1);

        List<Student> studentList0 = JSONArray.parseArray(s, Student.class);
        for (Student student : studentList0) {
            System.out.println(student.toString());
        }

        List<Student> studentList1 = JSONArray.parseArray(s1, Student.class);
        for (Student student : studentList1) {
            System.out.println(student.toString());
        }
    }

}
