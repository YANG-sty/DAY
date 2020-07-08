package com.sys.DesignPatterns.FlyweightPatterns;

/**
 * 享元模式
 * Create by yang_zzu on 2020/7/8 on 21:16
 */
public class FlyweightTest {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3, 4, TreeFactory.getTree("123", "xxxxxxxxxxxxx"));
        TreeNode treeNode1 = new TreeNode(5, 6, TreeFactory.getTree("123", "xxxxxxxxxxxxx"));

        System.out.println(treeNode);
        System.out.println(treeNode1);

    }
}
