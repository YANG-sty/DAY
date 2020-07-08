package com.sys.DesignPatterns.BuilderPatterns.v2;

/**
 * 在对象构建的过程中是有一定的先后顺序的
 * Create by yang_zzu on 2020/7/7 on 20:09
 */
public class Product {
    // 不可变对象
    private final String productName;
    private final String companyName;
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;
    private final String part5;
    private final String part6;

    /*public Product() {
    }*/

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4, String part5, String part6) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.part5 = part5;
        this.part6 = part6;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", part5='" + part5 + '\'' +
                ", part6='" + part6 + '\'' +
                '}';
    }

    //定义一个静态内部类，规定创建的顺序
    static class Builder {
        private String productName;
        private String companyName;
        private String part1;
        private String part2;
        private String part3;
        private String part4;
        private String part5;
        private String part6;

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder part1(String part1) {
            this.part1 = part1;
            return this;
        }

        public Builder part2(String part2) {
            this.part2 = part2;
            return this;
        }

        public Builder part3(String part3) {
            this.part3 = part3;
            return this;
        }

        public Builder part4(String part4) {
            this.part4 = part4;
            return this;
        }

        public Builder part5(String part5) {
            this.part5 = part5;
            return this;
        }

        public Builder part6(String part6) {
            this.part6 = part6;
            return this;
        }

        Product build() {
            //............
            Product product = new Product(this.productName, this.companyName, this.part1, this.part2, this.part3, this.part4, this.part5, this.part6);
            return product;
        }

    }
}
