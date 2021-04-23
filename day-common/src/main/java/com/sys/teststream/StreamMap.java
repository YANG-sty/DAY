package com.sys.teststream;

import com.sys.DesignPatterns.FactoryPatterns.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yangLongFei 2021-01-14-16:55
 */
public class StreamMap {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Proeduct{
        private String name;
        private String id;
        private Double value;
    }

    public static void main(String[] args) {
        System.out.println("123");
    }

    @Test
    public void test1() {
        Proeduct pingguo = new Proeduct("pingguo", "0", 100.00);
        Proeduct pingguo1 = new Proeduct("pingguo", "1", 101.00);
        Proeduct pingguo2 = new Proeduct("pingguo2", "2", 102.00);
        Proeduct pingguo3 = new Proeduct("pingguo3", "3", 103.00);
        Proeduct pingguo4 = new Proeduct("pingguo4", "4", 104.00);

        List<Proeduct> proeducts = new ArrayList<>();
        proeducts.add(pingguo);
        proeducts.add(pingguo1);
        proeducts.add(pingguo2);
        proeducts.add(pingguo3);
        proeducts.add(pingguo4);

        /**
         * List<String> people
         *          = people.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));
         */
        List<Proeduct> collect3 = proeducts.stream().collect(Collectors.collectingAndThen(Collectors.toList(), pro -> {
            return pro;
        }));

        Map<String, List<Proeduct>> collect4 = proeducts.stream().collect(Collectors.groupingBy(
                Proeduct::getName,
                Collectors.collectingAndThen(Collectors.toList(), pro -> {
                    return pro;
                })));

        Map<String, List<Proeduct>> collect6 = proeducts.stream().collect(Collectors.groupingBy(Proeduct::getName));

        Map<String, List<Proeduct>> collect5 = proeducts.stream().collect(Collectors.groupingBy(Proeduct::getName, Collectors.mapping(user ->{
            if (user.getId().equals("0")) {
                return user;
            } else {
                return null;
            }
        }, Collectors.toList())));


        //stream对象转map
        Map<Double, Proeduct> collect = proeducts.stream().collect(Collectors.toMap(Proeduct::getValue, Function.identity(), (v1, v2) -> v1));
        collect.forEach((aDouble, proeduct) -> System.out.println(aDouble.toString() + "  " + proeduct.toString()));

        //stream对象转map
        Map<Double, Proeduct> collect1 = proeducts.stream().collect(Collectors.toMap(Proeduct::getValue, Function.identity()));
        collect1.forEach((aDouble, proeduct) -> System.out.println(aDouble.toString() + " ### " + proeduct.toString()));

        //stream对象字段转字符串
        String collect2 = proeducts.stream().filter(p -> !p.getId().isEmpty()).map(proeduct -> proeduct.getId()).collect(Collectors.joining(","));
        System.out.println(collect2);
    }


    @Test
    public void test2() {
        Proeduct pingguo = new Proeduct("pingguo", "0", 100.00);

        Proeduct proeduct = new Proeduct();
        proeduct = pingguo;
        Proeduct pingguo1 = new Proeduct("pingguo", "1", 101.00);
        Proeduct pingguo2 = new Proeduct("pingguo", "2", 102.00);
        Proeduct pingguo3 = new Proeduct("香蕉", "3", 103.00);
        Proeduct pingguo4 = new Proeduct("香蕉", "4", 104.00);
        Proeduct pingguo5 = new Proeduct("香蕉", "4", 104.00);
        Proeduct pingguo6 = new Proeduct("西瓜", "4", 104.00);
        Proeduct pingguo7 = new Proeduct("西瓜", "4", 104.00);
        List<Proeduct> proeducts = new ArrayList<>();
        proeducts.add(pingguo);
        proeducts.add(pingguo1);
        proeducts.add(pingguo2);
        proeducts.add(pingguo3);
        proeducts.add(pingguo4);
        proeducts.add(pingguo5);
        proeducts.add(pingguo6);
        proeducts.add(pingguo7);

        //分组获得组内最小值
        Map<String, Optional<Proeduct>> collect = proeducts.stream().collect(
                Collectors.groupingBy(
                        Proeduct::getName,
                        Collectors.minBy(Comparator.comparing(Proeduct::getValue))
                ));


        for (Map.Entry<String, Optional<Proeduct>> stringOptionalEntry : collect.entrySet()) {
            Optional<Proeduct> value = stringOptionalEntry.getValue();
            System.out.println(value.get().toString());
        }

    }
}
