package com.sys.testMy;

import org.junit.Test;

/**
 * Create by yang_zzu on 2020/9/3 on 10:16
 */
public class MathRandomTest {

    @Test
    public void test1() throws InterruptedException {
        int i = 0;
        while (i < 10000) {
            double v1 = Math.random() * 9 + 1;
//            System.out.println(v1);

            int v = (int) ((v1)* 1000);
            System.out.println(v);

//            Thread.sleep(100);
            i++;
        }

    }

    @Test
    public void test2() {
        int i = 13 & 17;
        System.out.println(i);
        int i1 = 13 | 17;
        System.out.println(i1);

        int i2 = 13 ^ 17;
        System.out.println(i2);
    }
}
