package com.sys.DesignPatterns.Decorator.my;

/**
 * @author yangLongFei 2020-12-05-15:52
 */
public class Camaro0 implements Picture {
    private final Picture picture;

    public Camaro0(Picture picture) {
        this.picture = picture;
    }

    @Override
    public void zhaoxiang() {
        picture.zhaoxiang();
        System.out.println("照相 0 ---》");
    }
}
