package com.yang.sys.suanfa;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangLongFei 2020-12-11-15:43
 */
public class LRUmy {

    /**
     * 链表， hashMap 的节点
     */
    @Data
    static class Node {
        private Integer id;
        private String key;
        private String value;
    }


    /**
     * linkedList 数据是，按照有序排列的，最新的数据在链表尾部，旧的数据在链表头
     * hashMap 数据是无序的，目的是
     * 1. 在 get 数据的时候，保证时间复杂度为 O(1),
     * 2. 在 通过 hash 值判断元素是否存在的时候，时间复杂度也是 O(1)
     */
    LinkedList<Node> linkedList = new LinkedList<>();
    HashMap<Integer, Node> hashMap = new HashMap<>();
    // 用于计算hash 值的中间变量
    int h;
    // 缓存空间的大小
    int n = 5;

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("a0");
        list.add("1b");
        list.add("2c");
        list.add("3d");
        list.add("e4");
        list.add("f5");
        list.add("6g");
        list.add("g7");
        list.add("h8");
        list.add("91a");
        list.add("b10");
        list.add("cc11");

        //进行初始化, 将数据添加到， 链表，hashmap 中
        for (String s : list) {
            Node node = new Node();
            node.setKey(s);
            put(node);
        }

        // 模拟获得元素的情况
        Node node = new Node();
        node.setKey("91a");
        Node node1 = get(node);
        System.out.println("---------------------" + node1.getKey());

        linkedList.forEach(a -> System.out.println(a.getKey()));

    }

    /**
     * 存放数据
     */
    public void put(Node node) {
        Object hash = node.getKey() == null ? 0 : (h = node.getKey().hashCode()) ^ h >>> 16;
        int index = Integer.parseInt(String.valueOf(hash));
        boolean b = hashMap.containsKey(index);
        if (b) {
            // 包含数据进行更新
            if (hashMap.get(index).getKey().equals(node.getKey())) {
                // key值相同，说明是更新操作
                hashMap.put(index, node);
                linkedList.remove(node);
                linkedList.addLast(node);

            } else {
                //出现 hash 冲突，不用做，太麻烦
            }
        } else {
            //不包含数据， 进行追加
            if (linkedList.size() > n) {
                //溢出
                Node first = linkedList.getFirst();
                linkedList.removeFirst();
                hashMap.remove((n - 1) & (h = first.getKey().hashCode()) ^ h >>> 16);
            }
            // 不管是不是溢出，都要将 node 节点，放到链表的最后一个节点，放到 hashMap中相应的索引位置
            linkedList.addLast(node);
            hashMap.put(index, node);


        }

    }

    /**
     * 获得数据
     * 在获得数据的时候，是 O(1), 这也算是达到了 要求
     * 在移除数据的时候，时间复杂度不是 O(1), 需要对链表进行一次遍历，这个没有明显要求
     *
     * @param node
     * @return
     */
    public Node get(Node node) {
        //获得 hash 值
        int i = node.getKey().hashCode() ^ h >>> 16;
        if (hashMap.containsKey(i)) {
            //通过 hashMap 获取数据 是 O(1), 但是后面的维护
            Node node1 = hashMap.get(i);
            //在移除数据的时候，不是O(1)
            linkedList.remove(node1);
            linkedList.addLast(node1);
            return node1;
        } else {
            return null;
        }

    }

}

