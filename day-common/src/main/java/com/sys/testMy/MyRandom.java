package com.sys.testMy;

import org.junit.Test;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Create by yang_zzu on 2020/8/8 on 13:49
 */
public class MyRandom {
    
    @Test
    public void test1() {
        Random random = new Random();
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);

//        System.out.println(random.);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String myDate = "2020-05-01 12:11:11";
        try {
            Date parse = dateFormat.parse(myDate);
            int i = date.compareTo(parse);
            System.out.println(i);

            int i1 = parse.compareTo(date);
            System.out.println(i1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
