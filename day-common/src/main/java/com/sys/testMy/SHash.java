package com.sys.testMy;

import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Create by yang_zzu on 2020/7/24 on 9:16
 */
public class SHash {
    @Test
    public void test1() throws NoSuchAlgorithmException {

        Long a = Long.valueOf(111);

        String s = Long.toString(a & 0xff, 16);
        System.out.println(s);

        String abc = "enter";
        MessageDigest digest = null;
        digest = MessageDigest.getInstance("MD5");
        digest.update(abc.getBytes());
        String s1 = encodingHex(digest.digest());
        System.out.println(s1);

    }


    public static final String encodingHex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer(bytes.length * 2);
        for (byte aByte : bytes) {
            if ((aByte & 0xff) < 0x10) {
                stringBuffer.append("0");
            }
                //转换成16 进制，但是没有 0x
                stringBuffer.append(Long.toString(aByte & 0xff, 16));
        }
        return stringBuffer.toString();
    }







    public static final byte[] encoding(String st) {
        byte[] aaa;
        String[] split = st.split("");

        return null;

    }

    @Test
    public void test2() {
        int a = 16;
        int i = (a >>> 4) + a;
        int i1 = a & 0xff;
        System.out.println(i + "       " + i1);
    }
}
