package com.yang.sys.suanfa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangLongFei 2020-12-03-19:44
 */
public class SordArrayTest {

    /**
     * 冒泡排序
     */
    public int[] maoPao(int[] array, int n) {
        for (int i = n - 1; i > 0; i--) {
            int falg = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    falg = 1;
                }
            }
            if (falg == 0) {
                return array;
            }

        }
        return array;
    }

    @Test
    public void test1() {
        int[] array = new int[]{10, 11, 2, 3, 4, 1,11,21,32,20,15,18,17};
        int[] ints = maoPao(array, array.length);
        for (int anInt : ints) {
            System.out.print(anInt + "   ");
        }
    }


    /**
     * 快速排序
     */
    public int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int i = left;
            int a = right;
            int tmp = array[i];

            while (i < a) {
                // 右 向 左 ，查找 小于 temp
                while (i < a && tmp <= array[a]) {
                    a--;
                }
                if (i < a) {
                    array[i] = array[a];
                    i++;
                }
                // 左 向 右， 查找大于 tmp
                while (i < a && array[i] < tmp) {
                    i++;
                }
                if (i < a) {
                    array[a] = array[i];
                    a--;
                }
            }
            array[i] = tmp;
            quickSort(array, left, i-1);
            quickSort(array, i + 1, right);
        }

        return array;
    }

    @Test
    public void test3() {
        int[] array = new int[]{10, 11, 2, 3, 4, 1};
        int[] ints = quickSort(array, 0, array.length - 1);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ints.length; i++) {
            if (i < ints.length - 1) {
                stringBuffer.append(ints[i]);
                stringBuffer.append("   ");
            } else {
                stringBuffer.append(ints[i]);
            }
        }
        System.out.print(stringBuffer.toString());
    }


    /**
     * 指定插入排序
     */
    public int[] appointSort(int[] array ,int n) {
        // 查找最小的值，放到指定的位置
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i+1; j < n; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
        return array;
    }

    @Test
    public void test4() {
        int[] array = new int[]{10, 11, 2, 3, 4, 1};
        int[] ints = appointSort(array, array.length);
        for (int anInt : ints) {
            System.out.print(anInt + "   ");
        }

    }




    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = input.length - 1; i >= input.length - k; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
                if (i-1 == j) {
                    arrayList.add(input[i]);
                }

            }
        }
        //当 k 的值和，数组的值相同的时候，是冒泡排序，(冒泡排序最后一个数是不进行排序的)这个时候需要手动加上
        if(k == input.length){
            arrayList.add(input[0]);
        }

        return arrayList;

    }

    @Test
    public void test2() {
        int[] array = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(array, 8);
        arrayList.forEach(a -> System.out.print(a + "   "));
    }
}
