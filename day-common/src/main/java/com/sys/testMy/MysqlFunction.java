package com.sys.testMy;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author yangLongFei 2021-04-09-15:06
 */
public class MysqlFunction {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(inet_aton((Inet4Address) address));
        System.out.println(inet_ntoa(Long.valueOf("3232246785")));

        System.out.println(inet_aton("192.168.2.12"));
        System.out.println(inet_ntoa(Long.valueOf("3232236044")));

        System.out.println(inet_aton("255.255.255.255"));
        System.out.println(inet_ntoa(Long.valueOf("4294967295")));
    }
    @Test
    public void test() throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println(inet_aton((Inet4Address) address));
        System.out.println(inet_ntoa(Long.valueOf("3232246785")));

        System.out.println(inet_aton("192.168.2.12"));
        System.out.println(inet_ntoa(Long.valueOf("3232236044")));

        System.out.println(inet_aton("255.255.255.255"));
        System.out.println(inet_ntoa(Long.valueOf("4294967295")));

    }

    public static String inet_ntoa(Long add) {
        return ((add & 0xff000000) >> 24) + "." + ((add & 0xff0000) >> 16)
                + "." + ((add & 0xff00) >> 8) + "." + ((add & 0xff));
    }

    public static long inet_aton(Inet4Address add) {
        byte[] bytes = add.getAddress();
        long result = 0;
        for (byte b : bytes) {
            if ((b & 0x80L) != 0) {
                result += 256L + b;
            } else {
                result += b;
            }
            result <<= 8;
        }
        result >>= 8;
        return result;
    }

    /**
     * significantly faster than parse the string into long
     */
    public static long inet_aton(String add) {
        long result = 0;
        // number between a dot
        long section = 0;
        // which digit in a number
        int times = 1;
        // which section
        int dots = 0;
        for (int i = add.length() - 1; i >= 0; --i) {
            if (add.charAt(i) == '.') {
                times = 1;
                section <<= dots * 8;
                result += section;
                section = 0;
                ++dots;
            } else {
                section += (add.charAt(i) - '0') * times;
                times *= 10;
            }
        }
        section <<= dots * 8;
        result += section;
        return result;
    }
}
