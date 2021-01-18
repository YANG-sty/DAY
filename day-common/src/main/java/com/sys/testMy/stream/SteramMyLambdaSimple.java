package com.sys.testMy.stream;

import org.junit.Test;

/**
 * Create by yang_zzu on 2020/7/18 on 17:08
 */
public class SteramMyLambdaSimple {


    /**
     * 1. 必须是函数式接口
     * 2. 参数的传递
     *
     */
    @Test
    public void test1() {
        /**
         * 参数特性：
         * 可以忽略参数类型 name, age
         * 参数只有一个的时候，可以省略 括号 (name, age) ---》 name
         *
         * 代码编写特性：
         * 1. 单行表达式，省掉 return
         * 2. 代码块
         * 3. 静态方法引用
         * 4. 普通方法引用
         */
        //1. 单行表达式，省掉 return
        run((name, age) -> String.format("%s 的年龄是 %s",name,age) );
        //2. 代码块
        run((name, age) -> {
            System.out.println(name + " 的年龄是 " + age);
            return name;
        });
        //3. 静态方法引用
        run(SteramMyLambdaSimple::doFormat);
        //4. 普通方法引用
        run(new SteramMyLambdaSimple()::doFormat2);

    }

    public static String doFormat(String s, int age) {
        return "name : " + s;
    }

    public String doFormat2(String s, int age) {
        return "name : " + s;
    }

    public static void run(Format format) {
        format.run("yang_zzu", 18);
    }

    public interface Format {
//        void run(String name, int age);
        String run(String name, int age);
    }


}

