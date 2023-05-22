package org.fotech.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 栈是先进后出
public class MyQueue {
    // 临时栈
    Deque<Integer> inStack = new ArrayDeque<>();
    // 操作栈
    Deque<Integer> outStack = new ArrayDeque<>();
    public MyQueue() {

    }

    public void push(int x) {
       inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }

        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }

        return outStack.peek();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public boolean empty() {
        return outStack.isEmpty();
    }
}
