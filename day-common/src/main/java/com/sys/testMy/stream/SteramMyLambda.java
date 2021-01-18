package com.sys.testMy.stream;

import org.jasypt.commons.CommonUtils;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Create by yang_zzu on 2020/7/18 on 17:08
 */
public class SteramMyLambda {

    public static void main(String[] args) {
        start(() -> System.out.println("abc"));
    }

    public static void start(myRun2 myRun2) {
        new Thread(myRun2).start();
    }

    /**
     * 函数式接口
     * 1.只能有一个方法
     * 2.默认方法除外
     * 3.不是一个默认方法，是一个方法，也是一个函数式接口（Object 中的方法, equals, toString ）
     */
    @FunctionalInterface //这个注解，加不加都可以，加上注解，在不满足条件的情况下会报错误提示
    public interface myRun2 extends Runnable {

        //静态方法
        public static void run2() {

        }
        // 默认方法
        /*public default void run2() {

        }*/

        @Override
        String toString();

        @Override
        boolean equals(Object o);

    }

    @Test
    public void test1() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(i + "yang");
        }
        for (int i = 0; i < 10; i++) {
            stringList.add(null);
        }
        Map<Boolean, List<String>> map = stringList.stream().collect(Collectors.groupingBy(s -> CommonUtils.isNotEmpty(s)));
        List<String> stringList1 = map.get(Boolean.FALSE);
        System.out.println(stringList1.size());

    }

    @Test
    public void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //将 string 装换成带有 T 的国际时间，但是没有进行，时区的转换，即没有将时间转为国际时间，只是格式转为国际时间
        LocalDateTime parse = LocalDateTime.parse("2022-01-11 10:45:44", dateTimeFormatter);
        //+8 小时，offset 可以理解为时间偏移量
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        //转换为 通过时间偏移量将 string -8小时 变为 国际时间，因为亚洲上海是8时区
        Instant instant = parse.toInstant(offset);
        System.out.println(instant);
        // 打印毫秒
        System.out.println(System.currentTimeMillis());

        Date date = new Date();
    }


    @Test
    public void test3() {
//        Map<String, Map<String, List<Product>>> prodMap= prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.groupingBy(item -> {
//            if(item.getNum() < 3) {
//                return "3";
//            }else {
//                return "other";
//            }
//        })));


//{"啤酒":{"other":[{"category":"啤酒","id":4,"name":"青岛啤酒","num":3,"price":10},{"category":"啤酒","id":5,"name":"百威啤酒","num":10,"price":15}]},"零食":{"other":[{"category":"零食","id":3,"name":"月饼","num":3,"price":30}],"3":[{"category":"零食","id":1,"name":"面包","num":1,"price":15.5},{"category":"零食","id":2,"name":"饼干","num":2,"price":20}]}}

//        Map<String, Set<String>> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory,
//                Collectors.mapping(Product::getName, Collectors.toSet())));

//{"啤酒":["青岛啤酒","百威啤酒"],"零食":["面包","饼干","月饼"]}



    }








}

