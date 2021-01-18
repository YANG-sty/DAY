package com.yang.sys.suanfa;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author yangLongFei 2020-11-29-19:33
 */
public class QueueTest {

    @Test
    public void test1() {
        Queue queue = new ArrayDeque();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        while (queue.size() > 0) {
            Object poll = queue.poll();
            System.out.println(poll);
        }

        System.out.println(queue.size());

        Queue newQueue = new ArrayDeque();
        newQueue.add(1);
        newQueue.add(2);
        newQueue.add(3);
        newQueue.add(4);
        queue = newQueue;
        queue.forEach(q -> System.out.println(q.toString()));

        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.clear();
        arrList.forEach(a -> System.out.println(a));
        System.out.println(arrList.size());

    }
}
