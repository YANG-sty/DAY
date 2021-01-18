package com.sys.myproxy.javassist;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.CtNewMethod;

public class MyGenerator {
  
    public static void main(String[] args) throws Exception {  

        TestService testService = createProxy();
        testService.sayHello2("hahah");

    }

    public interface TestService {
        String sayHello(String name);

        void sayHello2(String name);

        void sayHello3(String name, int i);

        void sayHelloN(String name);
    }

    // javassist  工具类
    public static TestService createProxy() throws Exception {
        ClassPool classPool = new ClassPool(); // javassist -->ASM  -->编辑JVM指令码
        // classloader （类是通过 classload 进行寻找的）
        classPool.appendSystemPath();

        // 1.创建一个类
        CtClass class1 = classPool.makeClass("TestServiceImpl");
        //添加要实现的接口
        class1.addInterface(classPool.get(TestService.class.getName()));

        // 2.创建一个方法
        CtMethod sayHello = CtNewMethod.make(
                CtClass.voidType, //返回值类型
                "sayHello2", //方法名称
                new CtClass[]{classPool.get(String.class.getName())}, //参数类型
                new CtClass[0], //接口异常
                "{System.out.println(\"hello:\"+$1);}", //接口实现
                class1 //方法属于哪个类
        );
        //将方法 添加到 class1 类里面
        class1.addMethod(sayHello);

        //3.实例化这个对象
        Class aClass = classPool.toClass(class1);
        // 强制转换
        return (TestService) aClass.newInstance();
    }

}  