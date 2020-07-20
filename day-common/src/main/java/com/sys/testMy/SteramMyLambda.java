package com.sys.testMy;

/**
 * Create by yang_zzu on 2020/7/18 on 17:08
 */
public class SteramMyLambda {

    public static void main(String[] args) {
        start(() -> System.out.println("abc"));
    }

    public static void start(myRun2 myRun2) {
        new Thread(myRun2).start();
    }

    /**
     * 函数式接口
     * 1.只能有一个方法
     * 2.默认方法除外
     * 3.不是一个默认方法，是一个方法，也是一个函数式接口（Object 中的方法, equals, toString ）
     */
    @FunctionalInterface //这个注解，加不加都可以，加上注解，在不满足条件的情况下会报错误提示
    public interface myRun2 extends Runnable {

        //静态方法
        public static void run2() {

        }
        // 默认方法
        /*public default void run2() {

        }*/

        @Override
        String toString();

        @Override
        boolean equals(Object o);

    }
}

