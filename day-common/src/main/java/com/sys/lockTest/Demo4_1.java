package com.sys.lockTest;

/**
 * @author yangLongFei 2020-12-18-20:27
 */
public class Demo4_1 extends Demo4{

    /**
     * 一个同步方法，调用另一个同步方法，能否得到锁
     * 另一个方法，可以得到锁
     * 两个方法使用的是同一把锁，称为 “可重入锁”
     *
     * 可重入锁 的另外一种形式
     */
    @Override
    synchronized void test1() {
        System.out.println("Demo4_1 test1 start ... ");
        super.test1();
        System.out.println("Demo4_1 test1 end ... ");
    }

    public static void main(String[] args) {
        Demo4_1 demo4_1 = new Demo4_1();
        demo4_1.test1();

    }
}
