package com.sys.testMy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by yang_zzu on 2020/9/1 on 15:44
 */
public class MapTest {

    @Test
    public void test1() {
        // 结果
        Map<String, Double> map = new HashMap<String, Double>();

        map.put("a", 100.00);
        System.out.println("第一次：  "+map.size());

        map.clear();
        System.out.println("第二次:   "+map.size());
    }
}
