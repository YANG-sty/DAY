package com.sys.testMy;

import freemarker.template.utility.StringUtil;
import org.apache.commons.lang.StringUtils;

/**
 * Create by yang_zzu on 2020/7/11 on 14:26
 */
public class IntNull {

    public static void main(String[] args) {
        int a = 1 ;
        if (StringUtils.isNotBlank(String.valueOf(a))) {
            System.out.println("00000000000000");
        }
    }
}
