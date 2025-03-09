package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class Solution92 {
    public static void main(String[] args) {
//        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode input = new ListNode(3, new ListNode(5));
        Solution92 solution92 = new Solution92();
        solution92.reverseBetween(input, 1,2);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode pre = new ListNode();
        pre.next = curr;
        int i = 1;
        while (curr != null) {
            if (i == left) {
                pre.next = reserveNode(curr, right-left);
                break;
            }
            i++;
            pre = curr;
            curr = curr.next;
        }

        return head;
    }

    private ListNode reserveNode(ListNode curr, int right) {
        ListNode pre = null;
        ListNode head = curr;
        ListNode result = null;
        int i = 0;
        while (curr != null) {
            if (i == right) {
                head.next = curr.next;
                curr.next = pre;
                return curr;
            }
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            i++;
        }
        return result;
    }
}
