package com.sys.testMy;

import lombok.Synchronized;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * 字符串操作
 * @author y_zzu 2020-10-28-19:53
 */
public class StringFormat {
    /**
     * 字符串格式化
     */
    @Test
    public void test1() {
        String format = format("status %s reading %s", "2", "a", "b", "c");
        System.out.println(format);

    }

    /**
     * %n 换行符
     *
     *  <	格式化前一个转换符所描述的参数
     */
    @Test
    public void test1_1() {
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        Date date = new Date();
        //2021-01-18 10:03:44
        String format = format("%tF %<tT", date);
        System.out.println(format);

    }

    @Test
    public void test2() {
        List<String> stringList = new ArrayList<>();
        stringList.add("x");
        stringList.add("y");
        stringList.add("2");
        stringList.add("1");

        IntStream.range(0, stringList.size()).forEach(index -> {
            String s = stringList.get(index);
            System.out.println(s);
        });
    }

    /**
     * 字符串 大小比较，从小到大排序
     */
    @Test
    public void test3() {

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("v1.2.1");
        stringArrayList.add("v2.3.1");
        stringArrayList.add("v2.4.3");
        stringArrayList.add("2.5.3");
        stringArrayList.add("v2.5.4");
        stringArrayList.add("v3.2.1");

        for (int i = 0; i < stringArrayList.size(); i++) {
            for (int x = i + 1; x < stringArrayList.size(); x++) {
                int compareTo = stringArrayList.get(i).compareTo(stringArrayList.get(x));
                if (compareTo > 0) {
                    String tmp = stringArrayList.get(i);
                    stringArrayList.set(i, stringArrayList.get(x));
                    stringArrayList.set(x, tmp);
                }
            }
        }

        for (String s : stringArrayList) {
            System.err.println(s);
        }


    }



    @Test
    public void test4() {
        String s = "aaaaaaa".replaceAll("aa", "bb");
        System.out.println(s);

        String ss = "aaaaaa".replaceAll("\\u00A0", "");
        System.out.println(ss);
    }



}
