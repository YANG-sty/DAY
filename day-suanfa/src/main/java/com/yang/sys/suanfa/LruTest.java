package com.yang.sys.suanfa;

import org.junit.Test;

import java.util.*;

/**
 * @author yangLongFei 2020-11-24-14:06
 */
public class LruTest {

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer, Integer> lruMap = new LinkedHashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] opat : operators) {
            int key = opat[1];
            switch (opat[0]) {
                case 1:
                    int value = opat[2];
                    if (lruMap.size() < k) {
                        lruMap.put(key, value);
                    } else {
                        Iterator ot = lruMap.keySet().iterator();
                        lruMap.remove(ot.next());
                        lruMap.put(key, value);
                    }
                    break;
                case 2:
                    if (lruMap.containsKey(key)) {
                        int val = lruMap.get(key);
                        result.add(val);
                        lruMap.remove(key);
                        lruMap.put(key, val);
                    } else {
                        result.add(-1);
                    }
                    break;
                default:
            }
        }
        int[] resultArr = new int[result.size()];
        int i = 0;
        for (int a : result) {
            resultArr[i++] = a;
        }
        return resultArr;
    }


    /**
     * [1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2] 3
     */
    @Test
    public void test1() {

    }

}

