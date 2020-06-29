package com.sys;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by yang_zzu on 2020/6/15 on 15:41
 */
public class OR {
    public static void main(String[] args) {

        String a = "12";
        if (a.equals("1") || a.equals("2") || a.equals("12")) {
            System.out.println(a);
        }
        String abc = "a,b,c,d,e,f";
        List<String> collect = Arrays.stream(abc.split(",")).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

    }
}
