package com.sys.myproxy.cjlib;

import java.lang.reflect.Method;
  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy;  
/**
 * 实现了方法拦截器接口
 * Create by yangLongFei on 2021/1/13 on 20:18
 */
public class Hacker implements MethodInterceptor {

    @Override  
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");  
        proxy.invokeSuper(obj, args);  
        System.out.println("****  Oh,what a poor programmer.....");  
        return null;  
    }  
  
}  