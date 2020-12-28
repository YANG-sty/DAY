package com.sys.lockTest;

/**
 * @author yangLongFei 2020-12-18-22:24
 */
public class Demo11 {

    /**
     * 使用字符串作为锁，字符串相同的情况下，在内存中实际上是在同一个内存地址中进行存储
     * 即，两个锁实际上是相同的
     */
    String s1 = "hello";
    String s2 = "hello";

    public void  test1() {
        synchronized (s1) {

        }
    }

    public void  test2() {
        synchronized (s2) {

        }
    }
}
