package com.yang.sys.suanfa;


/**
 * @author yangLongFei 2020-11-27-12:40
 */
public class LRUCacheTest {


    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        if (operators == null || operators.length == 0) return null;
        int size = 0;
        for (int i = 0; i < operators.length; i++) {
            //若opt=1，接下来两个整数x, y，表示set(x, y)
            //若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
            int oper = operators[i][0];
            if (oper == 2) {
                size++;
            }
        }
        int[] res = new int[size];

        LRUCache cache = new LRUCache(k);
        int index = 0;
        for (int i = 0; i < operators.length; i++) {
            //获得第 i 组数据
            int[] data = operators[i];
            switch (data[0]) {
                // 第 i 组数据，第一个参数为 1 表示 set
                case 1:
                    cache.set(data[1], data[2]);
                    break;
                // 第 i 组数据，第一个参数为 2 表示 get
                case 2:
                    int v = cache.get(data[1]);
                    res[index++] = v;
                    break;
                default:
                    break;
            }
        }
        return res;
    }


    class LRUCache {
        private final int capacity;
        private final Node[] hashTable;
        private int nodeCount = 0;
        private Node head;
        private Node tail;

        public LRUCache(int c) {
            if (c < 1) {
                throw new IllegalArgumentException();
            }
            this.capacity = c;
            hashTable = new Node[(int) (c / 0.75)];
        }

        public void set(int key, int value) {
            int index = hashKey(key);
            //获得 第 index 个 node 结点
            Node node = hashTable[index];
            //结点不为空， 结点的 key 和 kye 不相等，说明是 两个key 的余数相等
            while (node != null && node.key != key) {
                node = node.hashTableLinkNode;
            }
            //结点不为空， key 值相等，进行更新操作
            if (node != null) {
                node.value = value;
                updateCache(node);
                return;
            }
            // 结点为空，集合中，没有该节点的信息，新建一个节点
            Node temp = new Node(key, value);
            temp.hashTableLinkNode = hashTable[index];
            hashTable[index] = temp;

            // 集合节点的数量为 0 ，则说明是第一个节点
            if (nodeCount++ == 0) {
                head = temp;
                tail = temp;
            } else {
                // 集合不为空，则将结点放到 集合末尾，作为尾结点
                temp.preNode = tail;
                tail.nextNode = temp;
                tail = temp;
            }

            // 集合节点数量大于，预设的节点数量， 需要清除不常用的节点
            if (nodeCount > this.capacity) {
                expireNode();
            }
        }

        private void expireNode() {
            Node node = head;
            if (node == null) return;
            head = node.nextNode;
            head.preNode = null;
            node.nextNode = null;

            int index = hashKey(node.key);
            Node curr = hashTable[index];
            Node last = null;
            while (curr != null && curr != node) {
                last = curr;
                curr = curr.hashTableLinkNode;
            }

            if (last == null) {
                hashTable[index] = node.hashTableLinkNode;
            } else {
                last.hashTableLinkNode = node.hashTableLinkNode;
            }

            node.hashTableLinkNode = null;
            nodeCount--;

        }

        public int get(int key) {
            int index = hashKey(key);
            Node node = hashTable[index];
            while (node != null && node.key != key) {
                node = node.hashTableLinkNode;
            }
            if (node == null) return -1;
            int value = node.value;
            //更新
            updateCache(node);
            return value;
        }


        private void updateCache(Node node) {
            //结点是，最后一个，不进行操作
            if (node.nextNode == null) return;
            // 结点为 中间结点
            if (node.preNode != null) {
                node.preNode.nextNode = node.nextNode;
                node.nextNode.preNode = node.preNode;
            } else {
                //结点为头结点
                node.nextNode.preNode = null;
                this.head = node.nextNode;
            }
            //将结点追加到，尾结点
            node.nextNode = null;
            node.preNode = tail;
            this.tail.nextNode = node;
            this.tail = node;
        }

        private int hashKey(int key) {
            return (key < 0 ? (key == Integer.MIN_VALUE ? 0 : -key) : key) % hashTable.length;
        }

    }

    static class Node {
        private int key;
        private int value;
        private Node preNode;
        private Node nextNode;
        private Node hashTableLinkNode;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
