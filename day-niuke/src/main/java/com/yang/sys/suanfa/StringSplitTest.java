package com.yang.sys.suanfa;

import org.junit.Test;

import java.util.Stack;

/**
 * @author yangLongFei 2020-11-29-21:14
 */
public class StringSplitTest {

    public boolean isValid (String s) {
        // write code here
        boolean b = false;
        Stack stack = new Stack();
        for(int i =0 ; i< s.length(); i++){
            if(stack.size()>0){
                String pre = (String)stack.peek();
                String substring = s.substring(i, i + 1);
                if (pre.equals("(")) {
                    if (substring.equals(")")) {
                        b = true;
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (pre.equals("[")) {
                    if (substring.equals("]")) {
                        b = true;
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (pre.equals("{")) {
                    if (substring.equals("}")) {
                        b = true;
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }else{
                stack.add(s.substring(i, i+1));
            }
        }

        if(stack.size()>0){
            return false;
        }

        return b;
    }


    @Test
    public void test() {

        boolean valid = isValid("[]");
        System.out.println(valid);



    }


}
