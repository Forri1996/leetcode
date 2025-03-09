package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 实现一个合并两个链表的方法，然后通过ans保存结果，依次合并
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoNode(result, lists[i]);
        }


        return result;

    }

    public ListNode mergeTwoNode(ListNode one, ListNode two) {
        if (one == null) return two;
        if (two == null) return one;
        ListNode head = new ListNode();
        ListNode result = head;
        ListNode left = one;
        ListNode right = two;

        while (left != null && right != null) {
            // 判断curr当前与另一个node相比
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        // 循环结束，说明有一个已经是null了
        head.next = left == null ? right : left;

        return result.next;
    }
}
