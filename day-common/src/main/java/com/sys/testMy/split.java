package com.sys.testMy;

/**
 * Create by yang_zzu on 2020/6/6 on 15:14
 */
public class split {

    public static void main(String[] args) {

        String s = "a,b,c,d,e";
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (i < split.length - 1) {
                stringBuffer.append(s1);
                stringBuffer.append(";");
            } else {
                stringBuffer.append(s1);
            }
        }
        System.out.println(stringBuffer);

    }

}
