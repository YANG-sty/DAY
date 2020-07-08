package com.sys.DesignPatterns.PrototypePatterns;

/**
 * 原型模式
 * Create by yang_zzu on 2020/7/8 on 19:21
 */
public class PrototyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("1234");
        Product product = new Product("part1", "part2", 3, 4,baseInfo);
        System.out.println(product);
        //实现浅拷贝（继承Cloneable 重写 clone 方法）
        Product clone = product.clone();
        System.out.println(clone);

        product.setPart4(40);
        product.getBaseInfo().setCompanyName("xxxxx");
//        baseInfo.setCompanyName("xxxxx");

        System.out.println(product);
        System.out.println(clone);


    }
}
