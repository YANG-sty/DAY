package com.sys.DesignPatterns.FlyweightPatterns;

/**
 * Create by yang_zzu on 2020/7/8 on 21:10
 */
public class TreeNode {
    private int x;
    private int y;
    private Tree tree;

    @Override
    public String toString() {
        return super.hashCode()+"}TreeNode{" +
                "x=" + x +
                ", y=" + y +
                ", tree=" + tree +
                '}';
    }

    public TreeNode() {
    }

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
