package com.sys.teststream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yangLongFei 2021-01-14-16:55
 */
public class StreamMap {

    @Data
    @AllArgsConstructor
    class Proeduct{
        private String name;
        private String id;
        private Double value;
    }


    @Test
    public void test1() {
        Proeduct pingguo = new Proeduct("pingguo", "0", 100.00);
        Proeduct pingguo1 = new Proeduct("pingguo1", "1", 101.00);
        Proeduct pingguo2 = new Proeduct("pingguo2", "2", 102.00);
        Proeduct pingguo3 = new Proeduct("pingguo3", "3", 103.00);
        Proeduct pingguo4 = new Proeduct("pingguo4", "4", 104.00);

        List<Proeduct> proeducts = new ArrayList<>();
        proeducts.add(pingguo);
        proeducts.add(pingguo1);
        proeducts.add(pingguo2);
        proeducts.add(pingguo3);
        proeducts.add(pingguo4);

        Map<Double, Proeduct> collect = proeducts.stream().collect(Collectors.toMap(Proeduct::getValue, Function.identity(), (v1, v2) -> v1));
        collect.forEach((aDouble, proeduct) -> System.out.println(aDouble.toString() + "  " + proeduct.toString()));

        Map<Double, Proeduct> collect1 = proeducts.stream().collect(Collectors.toMap(Proeduct::getValue, Function.identity()));
        collect1.forEach((aDouble, proeduct) -> System.out.println(aDouble.toString() + "   " + proeduct.toString()));
    }
}
