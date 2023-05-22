package org.fotech.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class MyStack {
    // 临时队列
    private Queue<Integer> queueA;
    // 操作队列
    private Queue<Integer> queueB;

    public MyStack() {
        queueA = new LinkedBlockingQueue<>();
        queueB = new LinkedBlockingQueue<>();

    }

    public void push(int x) {
        queueA.add(x);
        while (!queueB.isEmpty()) {
            queueA.offer(queueB.poll());
        }

        Queue<Integer> tmp = queueA;
        queueA = queueB;
        queueB = tmp;
    }

    public int pop() {
        return queueB.poll();

    }

    public int top() {
        return queueB.peek();
    }

    public boolean empty() {
        return queueB.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */