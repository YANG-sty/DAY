package com.yang.sys.suanfa;

import org.junit.Test;

/**
 * 二分查找法
 *
 * @author yangLongFei 2020-12-02-19:56
 */
public class erFenFindTest {


    /**
     * 二分查找,
     */
    public class Solution2 {
        /**
         *
         * @param n int整型 数组长度
         * @param v int整型 查找值
         * @param a int整型一维数组 有序数组
         * @return int整型
         */
        public int upper_bound_ (int n, int v, int[] a) {
            int left=0;
            int right = n-1;
            while(left<=right){
                int mid = (left+right)/2;
                if(a[mid]>=v){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return left+1;
        }
    }

    @Test
    public void test1() {
        int search = search(new int[]{3, 1}, 1);
        System.out.println(search);
    }
    public int search (int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int model = (right + left)/2;

            if (A[model] == target){
                return model;
                //这里必须是 小于等于，因为要查找，第一次出现的位置
            }else if( A[left] <= A[model] ){
                if(  A[left]<= target && target < A[model] ){
                    right = model - 1;
                }else{
                    left = model + 1;
                }
            }else {
                if( A[model] < target && target <= A[right] ){
                    left = model + 1;
                }else {
                    right = model - 1;
                }
            }
        }
        return -1;
    }

}
