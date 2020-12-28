package com.sys.DesignPatterns.Decorator.my;

import org.junit.Test;

/**
 * @author yangLongFei 2020-12-05-15:54
 */
public class PictureCamaroTest {

    @Test
    public void test1() {
        Picture picture = new Camaro3("######################");
        picture = new Camaro2(picture);
        picture = new Camaro1(picture);
        picture = new Camaro0(picture);

//        Picture picture = new Camaro0(new Camaro1(new Camaro2( new Camaro3("@@@@@@@@@@@@@@@"))));
        picture.zhaoxiang();
    }
}
