package com.sys;

import org.apache.commons.lang.StringUtils;

/**
 * Create by yang_zzu on 2020/6/13 on 15:17
 */
public class EnumTest {

    public static final EnumTest one = new EnumTest("haha",18);
    public static final EnumTest two = new EnumTest("xixi",19);
    public static final EnumTest three = new EnumTest("hoho",20);
    public static final EnumTest four = new EnumTest("lala",21);


    private int age;
    private String name;

    private EnumTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }



    public static void main(String[] args) {
        EnumTest one = EnumTest.one;
        EnumTest two = EnumTest.two;
        EnumTest three = EnumTest.three;
        EnumTest four = EnumTest.four;

        int oneAge = one.getAge();
        String oneName = one.getName();

        int twoAge = two.getAge();
        String twoName = two.getName();

        System.out.println(oneName + " 的年龄是；" + oneAge);
        System.out.println(twoName + " 的年龄是；" + twoAge);


        String a = "";
        String b = "";

        if (!"".equals(a) || a != null) {
            System.out.println("hahah");
        }

//        boolean empty = a.isEmpty();
        boolean blank = StringUtils.isBlank(a);
        boolean empty1 = StringUtils.isEmpty(a);
        System.out.println();


    }

}
