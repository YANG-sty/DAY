package com.sys.myproxy.cjlib;

import net.sf.cglib.proxy.Enhancer;

public class Test {

    /**
     * cglib 针对的是 class 文件
     *
     * 字节码生成技术实现AOP，其实就是 继承 被代理对象，然后 Override 需要被代理的方法，
     * 在覆盖该方法时，自然是可以插入我们自己的代码的。
     * 因为需要 Override 被代理对象的方法，所以自然 CGLIB 技术实现AOP时，
     * 就 必须要求需要被代理的方法不能是final方法，因为final方法不能被子类覆盖 。
     */
    public static void main(String[] args) {

        Programmer progammer = new Programmer();

        Hacker hacker = new Hacker();
        //cglib 中加强器，用来创建动态代理  
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(progammer.getClass());

        /**
         * 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，
         * 而Callback则需要实行 intercept() 方法进行拦截
         */
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();

    }
} 