package com.sys.DesignPatterns.BuilderPatterns.v1;


/**
 * Create by yang_zzu on 2020/7/7 on 20:16
 */
public interface ProductBuilder {

    void builderProductName(String productName);
    void builderCompanyName(String companyName);
    void builderPart1(String part1);
    void builderPart2(String part2);
    void builderPart3(String part3);
    void builderPart4(String part4);
    void builderPart5(String part5);
    void builderPart6(String part6);

    Product build();

}
