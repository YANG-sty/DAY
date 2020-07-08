package com.sys.DesignPatterns.BuilderPatterns.v2;

/**
 * Create by yang_zzu on 2020/7/7 on 20:44
 */
public class ProductBuilderTest {
    public static void main(String[] args) {
        Product.Builder builder = new Product.Builder().productName("HUAWEI").companyName("华为").part1("1").part2("2");
        Product build = builder.part3("3").part4("4").part5("5").part6("6").build();
        System.out.println(build);

    }
}
