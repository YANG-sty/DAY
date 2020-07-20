package com.sys.testMy;

/**
 * Create by yang_zzu on 2020/6/19 on 14:58
 */
public class IfTest {

    public static void main(String[] args) {
        int a = 2;
        if ((a = a * 2) > 6) {
            System.out.println("6");
        }
        System.out.println(a);

        String s = "b";
        if (s == null || !s.equals("a")) {
            System.out.println("hello");
        }

    }
}
