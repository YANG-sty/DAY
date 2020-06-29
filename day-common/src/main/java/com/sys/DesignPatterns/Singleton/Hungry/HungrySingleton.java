package com.sys.DesignPatterns.Singleton.Hungry;

/**
 * Create by yang_zzu on 2020/6/28 on 19:21
 */
public class HungrySingleton {
    /**
     * 静态代码，在对类实例化的时候会进行创建
     * 在调用 getInstance 的时候，会对类进行加载
     * 类加载过程：
     * 1.加载二进制数据到内存，生成 class 数据结构
     * 2.连接 ①验证===》class 是否符合JVM规范
     *        ②准备===》静态成员变量赋默认值 int 0, string null, bool false
     *        ③解析===> 符号引用（在编译时，java类并不知道所引用的类的实际地址）
     *                  转为
     *                  直接引用（直接引用可以是直接指向目标的指针,方法区的内存空间）
     * 3.初始化==》静态变量赋值
     */
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 设置为私有方法，防止 new HungarySingleton() 实例化对象
     * 抛出异常，防止通过反射的方式实例化对象
     */
    private HungrySingleton() {
        if (HungrySingleton.hungrySingleton != null) {
            throw new RuntimeException("单例模式，不允许多个实例！！！");
        }
    }

}
