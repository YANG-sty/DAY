package com.sys.DesignPatterns.Decorator.my;

/**
 * @author yangLongFei 2020-12-05-15:52
 */
public class Camaro3 implements Picture {
    private final String id ;

    public Camaro3(String id) {
        this.id = id;
    }

    @Override
    public void zhaoxiang() {
        System.out.println(id);
        System.out.println("照相 3 ---》");
    }
}
