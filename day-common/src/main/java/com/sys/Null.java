package com.sys;


import lombok.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Create by yang_zzu on 2020/5/27 on 13:56
 */
public class Null {


    private static void nonull(@NonNull String s) {
        System.out.println(s);
    }

    private static void nonull22(@Nullable String s) {
        System.out.println("1111111 -----> " + s);
    }

    public static void main(String[] args) {

        if ("11111" instanceof String) {
            System.out.println("字符串");
        }
        Integer integer = 111;
        if (integer instanceof Integer) {
            System.out.println("数字");

        }

        String a = null;
        nonull22(a);
        nonull(a);

    }


}
