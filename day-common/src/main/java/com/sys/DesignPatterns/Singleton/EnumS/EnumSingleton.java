package com.sys.DesignPatterns.Singleton.EnumS;

/**
 * 枚举类
 * Create by yang_zzu on 2020/6/28 on 20:25
 */
public enum EnumSingleton {

    enumSingleton;

    public void print() {
        System.out.println(this.hashCode());
    }

}
