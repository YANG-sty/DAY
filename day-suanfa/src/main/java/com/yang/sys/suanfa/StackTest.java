package com.yang.sys.suanfa;

import org.junit.Test;

import java.util.Stack;

/**
 * @author yangLongFei 2020-11-29-20:24
 */
public class StackTest {

    @Test
    public void test1() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        System.out.println(1);
    }

    @Test
    public void test() {
        Stack stack = new Stack();
        stack.push(65);
        stack.push(66);
        stack.add("A");
        stack.add("B");
        stack.push(97);
        stack.push(98);
        stack.add("a");
        stack.add("b");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

    }
}
