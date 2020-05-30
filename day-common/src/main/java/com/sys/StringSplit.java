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

        String s1 = "com.sys.StringSplit";
        Class<?> aClass = Class.forName(s1);
        Object o = aClass.newInstance();
        Method first = aClass.getMethod("secend");
        Object invoke = first.invoke(o);
        System.out.println(invoke);

        ModelAndView modelAndView = new ModelAndView();
        Model model = new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        modelAndView = (ModelAndView) model;





    }
}
