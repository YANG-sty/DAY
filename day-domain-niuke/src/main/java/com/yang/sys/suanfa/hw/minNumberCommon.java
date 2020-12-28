package com.yang.sys.suanfa.hw;

import org.junit.Test;

/**
 * @author yangLongFei 2020-12-04-16:16
 */
public class minNumberCommon {

    /**
     * 最小公倍数 = A * B / （两个数的最大公约数）
     * 最小公倍数
     */
    public static int getRes(int max, int min){
        for(int i = 1; i<min; i ++){
            int num = max * i;
            if(num % min == 0) {
                return num;
            }
        }
        return max*min;
    }




    @Test
    public void test1() {

        double a = -0.07;
        double result = 0;
        if( -1 < a && a < 1){
            if( a<0){
                result = lifanggen(1/(-a));
                result = -1/result;
            }else if(a>=0){
                result = lifanggen(1/a);
                result = 1/result;
            }
        }else if( a > 1){
            result = lifanggen(a);
        } else if(a< -1){
            result = -lifanggen(-a);
        }
        System.out.println(String.format("%.1f",result));

    }

    /**
     * 立方根， 二分法
     */
    public static double lifanggen(double n){
        double i = 0;
        double j = n;
        double mide = 0;
        while (i < j) {
            mide = (i + j) / 2;
            double add = mide * mide * mide;
            if (add - n < 0.001 && add - n > -0.001) {
                break;
            } else if (add > n) {
                j = mide;
            } else {
                i = mide;
            }
        }
        return mide;
    }





}
