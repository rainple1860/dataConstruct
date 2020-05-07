package com.rainple.construct;

import com.rainple.construct.stack.ArrayStack;
import com.rainple.construct.stack.LinkStack;

/**
 * @className: Test
 * @description:
 * @author: rainple
 * @create: 2020-04-15 20:19
 **/
public class Test {

    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
