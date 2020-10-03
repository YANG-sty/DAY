package com.sys.testMy;

import cn.hutool.core.bean.BeanUtil;
import freemarker.template.utility.StringUtil;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by yang_zzu on 2020/7/11 on 14:26
 */
public class IntNull {

    public static void main(String[] args) {
        int a = 1 ;
        if (StringUtils.isNotBlank(String.valueOf(a))) {
            System.out.println("00000000000000");
        }
    }

    @Test
    public void test1() {
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(4);

        List<Integer> blist = new ArrayList<>();
        blist.add(2);
        blist.add(3);
        blist.add(4);
        blist.add(5);

        boolean b = alist.retainAll(blist);

        System.out.println(b);

    }

    @Data
    class Student{
        int age;
        String name;
    }

    @Data
    class StudentDTO{
        Integer age;
        String name;
    }

    @Test
    public void test2() {
        Student student = new Student();

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("xiaoming");

        BeanUtil.copyProperties(studentDTO,student);

        System.out.println(student.toString());
        
        Integer a = 1;
        if (a != 0) {
            System.out.println(a);
        }
//        int b = Integer.parseInt("");
//        System.out.println(b);

        Integer c = Integer.parseInt("");
        System.out.println(c);
    }


}

