package org.fotech.hot100;

import org.fotech.bytedance.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution234 {
    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(solution234.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode m = head;
        int count=0;
        Stack<Integer> queue = new Stack<>();

        while (m != null) {
            count++;
            queue.add(m.val);
            m = m.next;
        }
        if (count % 2 != 0) count--;
        for (int i = 0; i < count / 2; i++) {
            if (queue.pop() != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
