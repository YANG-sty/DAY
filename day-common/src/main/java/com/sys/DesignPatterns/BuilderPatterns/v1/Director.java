package com.sys.DesignPatterns.BuilderPatterns.v1;

/**
 * 控制构建的先后顺序
 * Create by yang_zzu on 2020/7/7 on 20:21
 */
public class Director {
    //接口
    private ProductBuilder builder;

    // 控制建造的顺序
    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4, String part5, String part6) {
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderPart1(part1);
        builder.builderPart2(part2);
        builder.builderPart3(part3);
        builder.builderPart4(part4);
        builder.builderPart5(part5);
        builder.builderPart6(part6);

        Product product = builder.build();
        return product;
    }

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

}
