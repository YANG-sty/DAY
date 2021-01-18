package com.yang.sys.suanfa;

import org.apache.commons.lang.CharUtils;
import org.junit.Test;

/**
 * @author yangLongFei 2020-11-24-14:06
 */
public class CharSplit {

    @Test
    public void test1() {
        String s = "a.b.Z.c.d.E.f.s";
        String[] split = s.split("\\.");
        for (String s1 : split) {
            char c = CharUtils.toChar(s1);
            if (c >= 97) {
                char c1 = (char) (c - 32);
                System.out.println(c + " to " + c1);
            } else {
                System.out.println(c);
            }

        }


    }

    @Test
    public void tests2() {
        String s = "[]{}()";
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            String a = s.substring(i, i + 1);
            System.out.println(a);

        }
    }

}

