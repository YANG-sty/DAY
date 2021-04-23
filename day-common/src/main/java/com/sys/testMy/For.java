package com.sys.testMy;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by yang_zzu on 2020/7/14 on 8:56
 */
public class For {

    @Data
    static class Student {
        String name;
        int age;
        String phone;
    }

    public static void main(String[] args) {

        List<Student> students_1 = new ArrayList<>();
        Student student_1;
        for (int i = 1; i < 100000; i++) {
            student_1 = new Student();
            student_1.name = "yang_" + i;
            student_1.age = i;
            student_1.phone = "xxxxx" + i;
            students_1.add(student_1);
        }

        new Thread(() ->{
            try {
                //该线程睡 3 秒
                Thread.sleep(3000);

                long a = System.currentTimeMillis();

                for (Student student : students_1) {
                    Student sss = student;
                    System.out.println(sss.toString());
                }

                long b = System.currentTimeMillis();
                // nei : 445
                System.out.println("nei : " + (b - a));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();

        new Thread(() -> {

            long c = System.currentTimeMillis();

            Student sss_1;
            for (Student student : students_1) {
                sss_1 = student;
                System.out.println(sss_1.toString());
            }

            long d = System.currentTimeMillis();
            //wai : 647
            System.out.println("wai : " + (d - c));

        }).start();

    }

    @Test
    public void testThree() {

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        Student students = new Student();
        students.setAge(10);
        Student students1 = new Student();
        students1.setAge(11);

        studentLinkedList.add(students);
        studentLinkedList.add(students1);
        // forEache
        studentLinkedList.forEach(student -> {
            int age = student.getAge();
            System.out.println(age);
        });
        //增强型
        for (Student student : studentLinkedList) {
            int age = student.getAge();
            System.out.println(age);
        }
        //for i
        for (int i = 0; i < studentLinkedList.size(); i++) {
            Student student = studentLinkedList.get(i);
            int age = student.getAge();
            System.out.println(age);
        }
    }

    @Test
    public void abc() {
        // a 相当于list 集合中的原地址
        int a = 2;
        // b 相当于 增强型for 循环中， for (Student student : studentLinkedList) 中的 student
        int b = a;
        a = 3;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test2() {
        List<String> stringList = new ArrayList();
        stringList.add("a1");
        stringList.add("b2");
        stringList.add("c3");
        stringList.add("d4");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        Iterator iterator;
        for (String s : stringList) {
            System.out.println(s);
            //重新进行初始化操作
            iterator = integerList.iterator();
            while (iterator.hasNext()) {
                System.out.println(s + " : " + iterator.next());
                if (s.contains(iterator.toString())) {
                    iterator.remove();
                }
            }
        }
    }


    /*@Test
    public void Listabc() {
        Student student = new Student();
        Student student1 = new Student();
        Student student2 = new Student();

        student.setAge(0);
        student1.setAge(1);
        student2.setAge(2);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);

        for (Student student3 : studentList) {
            student3 = new Student();
            student3.setAge(100);
        }
        studentList.forEach(student3 -> {
            System.out.println(student3.getAge());
        });

        for (int i = 0; i < studentList.size(); i++) {
            Student student3 = studentList.get(i);
            student3 = new Student();
            student3.setAge(300);
        }

        studentList.forEach(student3 -> {
            System.out.println(student3.getAge());
        });

    }*/

    /*@Test
    public void volatileFor() {
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        Student students = new Student();
        students.setAge(10);
        Student students1 = new Student();
        students1.setAge(11);

        studentLinkedList.add(students);
        studentLinkedList.add(students1);

        Student student_;
        for (int i = 0; i < studentLinkedList.size(); i++) {
            student_ = studentLinkedList.get(i);
            System.out.println(student_.toString());
        }
    }*/

    /*@Test
    public void StrangFor() {
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        Student students = new Student();
        students.setAge(10);
        Student students1 = new Student();
        students1.setAge(11);

        studentLinkedList.add(students);
        studentLinkedList.add(students1);

        for (Student student : studentLinkedList) {
            System.out.println(student);
        }
    }*/

   /* @Test
    public void StreamFor() {
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        Student students = new Student();
        students.setAge(10);
        Student students1 = new Student();
        students1.setAge(11);
        studentLinkedList.add(students);
        studentLinkedList.add(students1);

        studentLinkedList.forEach(student -> {
            System.out.println(student.toString());
        });
    }*/

}
