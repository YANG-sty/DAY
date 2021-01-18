package com.sys.myproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    /**
     * jdk 是针对接口
     *
     * JDK动态代理要求被代理实现一个接口，只有接口中的方法才能够被代理 。
     * 其方法是将被代理对象注入到一个中间对象，而中间对象实现 InvocationHandler 接口，
     * 在实现该接口时，可以在 被代理对象调用它的方法时，在调用的前后插入一些代码。
     * 而 Proxy.newProxyInstance() 能够利用中间对象来生产代理对象。
     * 插入的代码就是切面代码。所以使用JDK动态代理可以实现AOP。
     *
     * ☆☆☆☆☆ 如果被代理对象实现了接口，那么就使用JDK的动态代理技术，反之则使用CGLIB来实现AOP，所以 Spring默认是使用JDK的动态代理技术实现AOP的 。
     *
     */
    public static void main(String[] args) {

        ElectricCar car = new ElectricCar();
        // 1.获取对应的ClassLoader  
        ClassLoader classLoader = car.getClass().getClassLoader();

        // 2.获取ElectricCar 所实现的所有接口  
        Class[] interfaces = car.getClass().getInterfaces();

        // 3.设置一个来自代理传过来的方法调用请求处理器，处理所有的代理对象上的方法调用  
        InvocationHandler handler = new InvocationHandlerImpl(car);  
        /* 
          4.根据上面提供的信息，创建代理对象 在这个过程中，  
                 a.JDK会通过根据传入的参数信息动态地在内存中创建和 XXXX.class 文件等同的字节码
                 b.然后根据相应的字节码转换成对应的class，  
                 c.然后调用newInstance()创建实例
         */
        Object o = Proxy.newProxyInstance(
                classLoader, //接口类
                interfaces, //需要实现的接口数组
                handler //处理接口方法调用的InvocationHandler实例
        );

        Vehicle vehicle = (Vehicle) o;
        vehicle.drive(); //方法调用

        Rechargable rechargeable = (Rechargable) o;
        rechargeable.recharge(); //方法调用


    }
}