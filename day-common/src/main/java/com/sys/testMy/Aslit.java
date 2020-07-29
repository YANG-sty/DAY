package com.sys.testMy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Create by yang_zzu on 2020/7/20 on 17:07
 */
public class Aslit {
    @Test
    public void test1() {
        int[] abc = new int[]{1, 2, 3, 4, 5};
        int[] def = new int[]{11, 22, 33, 44, 55};
        int[] hij = new int[]{111, 222, 333, 444, 555};
        List<int[]> ints = Arrays.asList(abc, def, hij);
        ints.stream()
                .forEach(a -> Arrays.stream(a)
                        .forEach(b -> System.out.println(b)));
    }
}
