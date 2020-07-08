package com.sys.DesignPatterns.FlyweightPatterns;

/**
 * Create by yang_zzu on 2020/7/8 on 21:08
 */
public class Tree {

    //树的名称
    private final String name;
    //该数一系列的数据，颜色，高度，大小，等组成树的具体数据信息
    private final String date;

    public Tree(String name, String date) {
        // 通过打印的方式，看树的对象创建了几次
        System.out.println(" name: " + name + "  createDate: " + date);
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }


    public String getDate() {
        return date;
    }


    @Override
    public String toString() {
        return super.hashCode()+"}Tree{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
