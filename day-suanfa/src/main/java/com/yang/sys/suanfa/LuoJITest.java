package com.yang.sys.suanfa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑运算 && ||
 *
 * @author yangLongFei 2020-11-30-11:18
 */
public class LuoJITest {


    @Test
    public void test() {
        boolean a = true && false || false;
        System.out.println(a);

        boolean b = false && true || true;
        System.out.println(b);

        boolean c = false && true || false;

        boolean d = true && false || true;

    }

    @Test
    public void test2() {
        boolean a = true;
        boolean b = false;
        if (a && !b) {
            System.out.println(b);
        }


        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.get(list.size() - 1));
    }


    @Test
    public void test3() {

    }

}
