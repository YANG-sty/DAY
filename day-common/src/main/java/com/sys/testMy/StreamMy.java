package com.sys.testMy;

import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create by yang_zzu on 2020/7/18 on 14:36
 */
public class StreamMy {
    private List<Apple> appleList1;

    @Data
    static class Apple{
        private int id;
        private String color;
        private int weight;
        private String origin;

        public Apple(int id, String color, int weight, String origin) {
            this.id = id;
            this.color = color;
            this.weight = weight;
            this.origin = origin;
        }
    }

    private static List<Apple> appleList = new ArrayList<>();

    static {
        appleList.add(new Apple(1, "read", 500, "河南"));
        appleList.add(new Apple(2, "read", 400, "河南"));
        appleList.add(new Apple(3, "green", 300, "河北"));
        appleList.add(new Apple(4, "green", 200, "河北"));
        appleList.add(new Apple(5, "green", 100, "河北"));
    }

    public List<Apple> condition(Predicate<? super Apple> pre) {
        List<Apple> collect = appleList.stream().filter(pre).collect(Collectors.toList());
        return collect;
    }

    /**
     * 对集合更具条件进行过滤
     */
    @Test
    public void test1() {
        List<Apple> read = new StreamMy().condition(apple -> apple.getColor().equals("read") && apple.getWeight() > 300);
        read.forEach(apple -> {
            System.out.println(apple);
        });
    }

    /**
     * 求出每个颜色平均重量
     * 传统方式
     */
    @Test
    public void test2() {
        //1. 对颜色分组
        Map<String, List<Apple>> listMap = new HashMap<>();
        appleList.forEach(apple -> {
            List<Apple> apples = listMap.computeIfAbsent(apple.getColor(), color -> new ArrayList<>());
            apples.add(apple);
        });

        //求平均值
        Map<String, Double> doubleMap = new HashMap<>();
        listMap.forEach((s, apples) -> {
            Double aDouble = doubleMap.computeIfAbsent(s, color -> {
                double wegiht = 0;
                for (Apple apple : apples) {
                    wegiht += apple.getWeight();
                }
                return wegiht/apples.size();
                });
        });

        doubleMap.forEach((s, aDouble) -> {
            System.out.println(s + " weight is " + aDouble);
        });

    }

    /**
     * 平局重量
     */
    @Test
    public void test3() {
        Map<String, Double> collect = appleList.stream().
                collect(
                        Collectors.groupingBy(
                                apple -> apple.getColor(), //颜色分组
                                Collectors.averagingLong(apple -> apple.getWeight()) //求出平均值
                        )
                );
        collect.forEach((s, aDouble) -> System.out.println(s + " is  " + aDouble));
    }


    /**
     * 流的生成
     */
    @Test
    public void test4() {
        appleList.stream();
        Arrays.stream(new int[]{1, 2, 3, 4, 5});
        Stream.of(1, 2, 3, 4);
    }

    /**
     * 流不可重复的进行使用
     * IllegalStateException
     */
    @Test
    public void test5() {

        Stream<Apple> stream = appleList.stream();
        // stream 第一次使用
        Stream<Apple> read = stream.filter(apple -> apple.getColor().equals("read"));
        // stream 第二次使用
//        Stream<Apple> appleStream = stream.filter(apple -> apple.getWeight() > 200);

        // read 流第一次使用
        Stream<Apple> appleStream = read.filter(apple -> apple.getWeight() > 400);

        /**
         * 如果返回的是一个 stream 则是中间节点
         * 如果返回的 不是 stream 则是终止节点
         */
        appleStream.forEach(apple -> System.out.println(apple.toString()));

//        appleStream.collect(Collectors.toList()).forEach(apple -> System.out.println(apple.toString()));
    }

    /**
     * 影响方式：
     * 1. 过滤
     * 2. 装换
     * 3. 去重
     * 4. 采集  list map groupby 数组 最大值 任意值
     */
    @Test
    public void test6() {
        appleList.stream()
                .filter(apple -> apple.getColor().equals("read") || apple.getColor().equals("green")) //过滤
                .map(apple -> apple.getWeight()) //转换
                .filter(w -> w > 300) //过滤
                .peek(w -> System.out.println("重量是：" + w)) //执行一个函数 peek 是一个中间节点
                .collect(Collectors.toList()) // 终止
                .forEach(w -> System.out.println(w)); // 执行一个函数 forEach 是一个终止节点   遍历

        appleList.stream()
                .filter(apple -> apple.getColor().equals("read") || apple.getColor().equals("green")) //过滤
                .map(apple -> apple.getColor())
                .distinct() //去重
                .forEach(apple -> System.out.println(apple));

        appleList.stream()
                .filter(apple -> apple.getColor().equals("read") || apple.getColor().equals("green")) //过滤
                .map(apple -> apple.getColor())
                .distinct() //去重
                .collect(Collectors.toList());
    }

    /**
     * 求出 每个颜色的任意一个对象的信息
     */
    @Test
    public void test7() {
        appleList.stream()
                .collect(Collectors.toMap( // map 集合（key， value）
                        apple -> apple.getColor(), // key 是颜色
                        apple -> apple,  // value 是 apple 对象
                        (apple, apple2) -> apple)) // 如果有多个value ,则取第一个
                .forEach((s, apple) -> System.out.println(apple.toString()));

    }



}
