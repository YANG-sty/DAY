package com.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

/**
 * Create by yang_zzu on 2020/5/29 on 16:24
 */
@Controller
@RequestMapping("/StringSplit")
public class StringSplit {
    @GetMapping("/first")
    public static String first(String abc) {
        System.out.println("first");
        return "first";
    }

    @GetMapping("/secend")
    @ResponseBody
    public static ModelAndView secend(String abc) {
        System.out.println("secend");
        return new ModelAndView().addObject("secend","2222222");
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String a = "com.sys.yang.zzu";
        String[] split = a.split("sys");
        int length = split.length;
        String s = split[1];
        System.out.println(s);

        String[] split1 = a.split("yang.");
        for (String s1 : split1) {
            System.out.println("yang    ：  "+s1);

        }

        /**
         * 反射的方式进行方法的执行
         */
        String s1 = "com.sys.StringSplit";
        Class<?> aClass = Class.forName(s1);
        Object o = aClass.newInstance();
        Method first = aClass.getMethod(
                "secend", //方法名
                String.class //返回值类型
        );
        Object invoke = first.invoke(
                o, //类对象
                "secend.abc" //执行方法传递的参数
        );
        System.out.println(invoke);







    }
}
