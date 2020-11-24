package com.yang.sys.suanfa;

import org.junit.Test;

/**
 * @author yangLongFei 2020-11-24-11:32
 */
public class ListNodeTest {

    /**
     * 链表结构体
     */
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 链表 反转的 方法
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            // 保存链表后面的数据，防止丢失
            next=head.next;
            /**
             * 这两条语句是核心
             * 执行的操作简单的来说是
             *  第一次 1 2 3 4
             *         1
             *  第二次 2 3 4
             *         2 1 (1 是第一次的 1)
             *  第三次 3 4
             *         3 2 1 （2 1 是第二次的 2 1）
             *  第四次 4
             *        4 3 2 1 （3 2 1 是 第三次的 3 2 1）
             * 1 2 3 4
             * 1
             *   2 1
             *     3 2 1
             *       4 3 2 1
             */
            head.next=pre;
            pre=head;
            // 将保存的链表后面的数据，重新赋给 head
            head=next;
        }
        return pre;
    }

    @Test
    public void test1() {
        //链表数据初始化
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        // 链表反转的方法
        ListNode reverseList = ReverseList(listNode);

        // 打印数据
        dayin(reverseList);

    }


    /**
     * 输出链表数据
     */
    public void dayin(ListNode listNode) {

        StringBuffer sb = new StringBuffer();
        while (listNode != null) {
            sb.append(listNode.val);
            if (listNode.next != null) {
                sb.append(",");
            }
            listNode = listNode.next;
        }
        System.out.println(sb.toString());

    }

}
