package com.sys.DesignPatterns.Singleton.StaticS;

/**
 * Create by yang_zzu on 2020/6/28 on 20:04
 */
public class StaticSingleton {
    /**
     * 静态代码块
     */
    private static class StaticClassHolder {
        private static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return StaticClassHolder.staticSingleton;
    }

    /**
     * 设置为私有方法，防止 new StaticSingleton() 实例化对象
     * 抛出异常，防止通过反射的方式实例化对象
     */
    private StaticSingleton() {
        if (StaticClassHolder.staticSingleton != null) {
            throw new RuntimeException("单例模式，不允许多个实例！！！");
        }
    }


}
