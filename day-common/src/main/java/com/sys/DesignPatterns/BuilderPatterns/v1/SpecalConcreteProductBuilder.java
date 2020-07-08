package com.sys.DesignPatterns.BuilderPatterns.v1;


/**
 * 另外一个产品的构建者
 * Create by yang_zzu on 2020/7/7 on 20:18
 */
public class SpecalConcreteProductBuilder implements ProductBuilder{

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;
    private String part6;


    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public void builderPart5(String part5) {
        this.part5 = part5;
    }

    @Override
    public void builderPart6(String part6) {
        this.part6 = part6;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4,this.part5,this.part6);
    }
}
