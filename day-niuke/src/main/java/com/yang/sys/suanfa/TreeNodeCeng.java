package com.yang.sys.suanfa;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author yangLongFei 2020-11-29-19:58
 */
public class TreeNodeCeng {

    @Setter
    @Getter
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> arrayListResult = new ArrayList<>();

        if(root != null){
            //保存当前层的数据
            Queue queue = new ArrayDeque();
            //保存下一层的数据
            Queue newQueue = new ArrayDeque();
            queue.add(root);
            ArrayList<Integer> arrList = new ArrayList<>();
            while(queue.size()>0){
                TreeNode node = (TreeNode)queue.poll();
                arrList.add(node.val);
                if(node.left != null){
                    newQueue.add(node.left);
                }
                if(node.right != null){
                    newQueue.add(node.right);
                }
                if(queue.size() == 0){
                    arrayListResult.add(arrList);
                    queue = newQueue;
                    newQueue = new ArrayDeque();
                    arrList = new ArrayList<>();
                }

            }
        }

        return arrayListResult;

    }


    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 9;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 20;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 15;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.val = 7;

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(treeNode);
        System.out.println(arrayLists.size());

//        arrayLists.forEach(r -> r.forEach(a -> System.out.println(a)));

    }



}
