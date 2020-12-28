package com.sys.testMy;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by yang_zzu on 2020/6/6 on 15:14
 */
public class split {

    public static void main(String[] args) {

        String s = "a,b,c,d,e";
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (i < split.length - 1) {
                stringBuffer.append(s1);
                stringBuffer.append(";");
            } else {
                stringBuffer.append(s1);
            }
        }
        System.out.println(stringBuffer);

    }
    
    
    @Test
    public void test1() {
        String a = "1.132132131.$1321546546513000000000";
        String[] strings = a.split("#");
        int length = strings.length;
        System.out.println(length);


    }


    @Test
    public void test2() {
        String a = "Android";
        String io = "Ios";
        String s = a.toLowerCase();
        System.out.println(s);
        String s1 = io.toLowerCase();
        System.out.println(s1);
    }

    @Test
    public void test3() {

        String a = "v11.2.3";
        String b = "v1.12.3";
        String c = "V1.21.3";
        String d = "V1.1.3";

        List<String> stringList = new ArrayList<>();
        stringList.add(a);
        stringList.add(b);
        stringList.add(c);
        stringList.add(d);
        List<String> collect = stringList.stream().map(String::toLowerCase).sorted(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        }).collect(Collectors.toList());

        collect.forEach(aa -> System.out.println(aa));

    }


    @Test
    public void test4() {
        String a = "1234567";
        char[] chars = a.toCharArray();
        StringBuffer sb = new StringBuffer();
        String substring = a.substring(0, a.length()/2);
        System.out.println(substring);

        int[] abc = new int[2];
        abc[1] = 10;
        abc[2] = 11;
    }

    @Test
    public void test5(){
        String a = "abcdefg123";
        char[] chars = a.toCharArray();
        char aChar = chars[1];
        System.out.println(aChar);

        System.out.println(aChar + 0);

        int abc = 97;
        char aaa = (char) abc;
        System.out.println(aaa);


//        System.out.println(Integer.parseInt(aChar));

    }


    @Test
    public void test6() {
        char[] s1 = "ABCabc".toCharArray();
        String s2 = "b";
        int re = 0;
        char key = s2.toCharArray()[0];
        for(int i = 0; i< s1.length; i++){
            if( 97 <= s1[i] && s1[i] <= 122 ){
                s1[i] = (char)(s1[i] - 32);
            }
            if (97 <= key && key <= 122) {
                key = (char) (key - 32);
            }
            if( s1[i] == key){
                re++;
            }
        }

        System.out.print(re);
    }

    @Test
    public void test7() {
        char[] s1 = "abcdef".toCharArray();
        for(int i = 0, j=s1.length-1; i < j ; i++,j--){
            char temp = s1[i];
            s1[i] = s1[j];
            s1[j] = temp;
        }
        for(int i = 0; i < s1.length; i++){
            System.out.print(s1[i]);
        }
    }


}
