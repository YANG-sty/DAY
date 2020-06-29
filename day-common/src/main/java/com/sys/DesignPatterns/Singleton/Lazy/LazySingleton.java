package com.sys.DesignPatterns.Singleton.Lazy;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒加载
 * Create by yang_zzu on 2020/6/28 on 17:24
 */
public class LazySingleton implements Serializable {
    private static final long serialVersionUID = -6742141705121513965L;
    /**
     * volatile
     * 防止字节码加载的时候发生指令重排序
     * 1. 分配空间
     * 2. 初始化
     * 3. 引用赋值
     * <p>
     * 否则加载的时候顺序可能变为
     * 1. 分配空间
     * 3. 引用赋值
     * 2. 初始化
     * 这个时候，如果一个线程 执行到 引用赋值
     * 另外一个线程，访问对象的时候，该对象不为空，但是由于没有进行初始化的操作，在对该对象进行其他操作的时候可能会发生空指针异常
     */
    private volatile static LazySingleton lazySingleton;


    public static LazySingleton getLazySingleton() {
        /**
         * 外层 if 判断，为了减少多线程之间对锁的竞争
         * 锁，是一个非常消耗时间的操作
         * 多线程的时候
         * 比如说有100 个线程，前面10 个线程同时进到了该 if 里面，然后里面的锁会挨个的对每个线程进行后面的操作
         * 此时 lazySingleton 不为空后面 90 个线程就不会去争抢锁
         */
        if (lazySingleton == null) {
            /**
             * 加锁
             * 多线程访问的时候
             * 两个线程同时进入到 if 方法里面，这个时候就会一个线程一个线程的执行后面的if 判断
             * 第一个最先得到锁的线程，会实例化 lazySingleton ,
             * 后面的线程判断 lazySingleton 不为空，就不会进行实例化，直接返回 lazySingleton
             */
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    /**
     * 设置为私有方法，不允许直接进行实例化对象  new LaySinglen()
     */
    private LazySingleton() {
        /**
         * 抛出异常，防止通过反射的方式 实例化对象
         */
        if (LazySingleton.lazySingleton != null) {
            throw new RuntimeException("单例模式，不允许多个实例！！！");
        }

    }


    /**
     * 反序列化
     * 从流中读取实例时需要指定替换的类应使用带有精确签名的特殊方法来实现。
     * 指定返回的数据，不实现该方法则会从 文件流 里面获取数据，
     * 实现该方法，获取到该方法返回的数据。
     */
    Object readResolve() throws ObjectStreamException {
        return LazySingleton.lazySingleton;
    }


}
