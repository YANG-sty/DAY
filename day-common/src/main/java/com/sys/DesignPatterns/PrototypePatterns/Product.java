package com.sys.DesignPatterns.PrototypePatterns;

import java.io.*;

/**
 * 原型模式
 * Create by yang_zzu on 2020/7/8 on 19:19
 */
public class Product implements Cloneable,Serializable {
    private static final long serialVersionUID = -2701668816333438049L;

    private String part1;
    private String part2;
    private Integer part3;
    private Integer part4;
    private BaseInfo baseInfo;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public Integer getPart3() {
        return part3;
    }

    public void setPart3(Integer part3) {
        this.part3 = part3;
    }

    public Integer getPart4() {
        return part4;
    }

    public void setPart4(Integer part4) {
        this.part4 = part4;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Product() {
    }

    public Product(String part1, String part2, Integer part3, Integer part4, BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return super.hashCode()+"}Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3=" + part3 +
                ", part4=" + part4 +
                ", baseInfo=" + baseInfo +
                '}';
    }

    /**
     * 浅拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    /*@Override
    protected Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }*/

    /**
     * 深拷贝
     *
     * 递归实现 Cloneable 的 clone 方法
     * @return
     * @throws CloneNotSupportedException
     */
    /*@Override
    protected Product clone() throws CloneNotSupportedException {
        BaseInfo clone = this.baseInfo.clone();
        Product product = (Product) super.clone();
        product.setBaseInfo(clone);
        return product;
    }*/

    /**
     * 序列化深拷贝
     *
     * 通过序列化的方式进行拷贝，在解析数据流的时候，需要CPU的参与，消耗资源比较多
     * 不建议使用这种方式
     * 类及子类，都需要实现 Cloneable,Serializable 并且赋予 UUID
     */
    @Override
    protected Product clone() throws CloneNotSupportedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Product object = (Product) objectInputStream.readObject();

            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}
