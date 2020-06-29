package com.sys;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by yang_zzu on 2020/6/18 on 14:36
 */
public class NodeTest {
    int b = 2;
    @Test
    public void asd() {

        int a = 1;
        if (a>0) {
            a = a + 2;
        } else if (a > 2) {
            a = a + 2;
        } else {
            a = 0;
        }

        System.out.println(a);
        Integer sum = this.sum(a);

        List<String> list = new ArrayList<>();
        for (int i = this.b ;; ) {

        }

    }
    Integer sum(int a){
        NodeTest nodeTest = this;
        System.out.println(nodeTest);
        return 1;
    }
}
