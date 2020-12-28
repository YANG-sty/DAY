package com.sys.testMy;

/**
 * @author yangLongFei 2020-12-13-10:50
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

/*class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] splits = in.nextLine().split(",");
            int[] arr = new int[splits.length];
            for (int i = 0; i < splits.length; i++) {
                arr[i] = Integer.parseInt(splits[i]);
            }
            for (int i = arr.length-1; i >0 ; i--) {
                for (int j = 0; j <= i; j++) {
                    if (arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j+1] = temp;
                    }
                }

            }

        }
    }
}*/

public class TestNewHW {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }



    @Test
    public void test1() {
        String[] splits = "5,10,2,11".split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        int count = 20;
        int add = 0;
        int flag = 0;
        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
            if( (add = add + arr[i])<= count ){
                flag++;
            }

        }
        System.out.print(flag);
    }


    @Test
    public void test2() {
        String[] splits = "4,4,0,0,3,3".split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        int x0 = arr[0];
        int y0 = arr[1];
        int[][] qq = new int[arr[0]][arr[1]];
        HashMap<String, Object> hs = new HashMap<>();
        int x1 = arr[2];
        int y1 = arr[3];
        int x2 = arr[4];
        int y2 = arr[5];

        int x = 0;
        int y = 0;
        if (0 < x1 && x1 < x2 && x2 < x0) {// 0 3
            x = Math.abs(x1) - Math.abs(x2 - x0) > 0 ? x1 : Math.abs(x2 - x0);
        } else if(0 < x2 && x2 < x1 && x1 < x0){// x1 > x2
            x = Math.abs(x2) - Math.abs(x1 - x0) > 0 ? x2 : Math.abs(x1 - x0);
        } else if (x1 == 0 && x2 == x0-1 ) {
            x = x0 - 1;
        }
        if(0 < y1 && y1 < y2 && y2 < y0){ // 0 3
            y =  Math.abs(y1) - Math.abs(y2 - x0) > 0 ? y1 : Math.abs(y2 - y0);
        }else if(0 < y2 && y2 < y1 && y1 < y0){ // y1 > y2
            y = Math.abs(y2) - Math.abs(y1 - y0) > 0 ? y2 : Math.abs(y1 - y0);
        }else if (y1 == 0 && y2 == y0-1 ) {
            y = y0 - 1;
        }
        //
        System.out.println(Math.max(x, y) + 1);

    }




    @Test
    public void test6() {
        Integer a = null;
        HashMap hashMap = new HashMap();

    }
}





