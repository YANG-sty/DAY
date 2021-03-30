package com.sys.testMy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author yangLongFei 2021-03-08-15:56
 */
public class TestObject {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Person {
        private int age;
        private double height;
    }


    @Test
    public void test1() {

        /**
         * byte
         * boolean
         *
         * short
         * char
         *
         * int
         * float
         *
         * long
         * double
         */
        Person[] people = new Person[]{new Person(10, 103), new Person(8, 113), new Person(12, 135),};

        //对象占用的内存空间  144 bytes
        System.out.println(RamUsageEstimator.humanSizeOf(people));

        /**
         * int 4
         * double 8
         *
         * 对象头 8
         * 指针 4/8
         * 对齐填充 8
         *
         * 8+4+8+4 = 24
         *
         * 48
         */
        Person person = new Person(1, 18);
        //对象占用的内存空间 48 bytes
        System.out.println(RamUsageEstimator.humanSizeOf(person));
        System.out.println();

    }


    @Test
    public void test2() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", "a");
        linkedHashMap.put("11", "aa");
        linkedHashMap.put("111", "aaa");
        linkedHashMap.put("2", "b");

        for (String s : linkedHashMap.keySet()) {
            System.out.println(s);
        }

        System.out.println("==============================");

        String remove = linkedHashMap.remove("1");
        System.out.println(remove);
        String put = linkedHashMap.put("1", remove);
        System.out.println(put);

        System.out.println("==============================");

        System.out.println(linkedHashMap.get("1"));

        for (String s : linkedHashMap.keySet()) {
            System.out.println(s);
        }


    }

    @Test
    public void test3() {
        HashMap<String, String> linkedHashMap = new HashMap<>();
        linkedHashMap.put("1", "a");
        linkedHashMap.put("11", "aa");
        linkedHashMap.put("111", "aaa");
        linkedHashMap.put("2", "b");

        for (String s : linkedHashMap.keySet()) {
            System.out.println(s);
        }


    }

    @Test
    public void test4() {
        String price = "1234567890.91";

//        String price = "123456789123";
        if (price.contains(".")) {
            String substring = price.substring(0, price.lastIndexOf("."));
            if (substring.length() > 10) {
                System.out.println(false);
                return;
            }
            String dian = price.substring(price.lastIndexOf(".") + 1, price.length());
            if (dian.length() > 2) {
                System.out.println(false);
                return;
            }
            System.out.println(true);
            return;
        } else {
            if (price.length() > 10) {
                System.out.println(false);
                return;
            }
            System.out.println(true);
            return;
        }

    }


    /**
     * 方式1：
     * 科学计数法 转 String
     */
    @Test
    public void test5() {
//        String scientificNotation = "1.23456789101E9";
        String scientificNotation = "123456.123";
        Double scientificDouble = Double.parseDouble(scientificNotation);
        NumberFormat nf = new DecimalFormat("################################################.###########################################");
        String format = nf.format(scientificDouble);
        System.out.println(format);
    }

    /**
     * 方式二：
     * 科学计数法，转为，字符串
     */
    @Test
    public void test6() {
        String a = "1.23456789101E9";
//        String a = "123456.123";
        System.out.println(new BigDecimal(a));
        System.out.println(new BigDecimal(a).toString());

    }


}
