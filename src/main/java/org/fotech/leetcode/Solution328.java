package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode ji = head;
        ListNode ou = head.next;
        if (ou == null) {
            return head;
        }

        ListNode jiHead = ji;
        ListNode ouHead = ou;

        ListNode curr = head.next.next;
        if (curr == null) {
            return head;
        }

        int i = 1;
        while (curr != null) {
            if (i % 2 == 1) {
                ji.next = curr;
                ji = curr;
            }

            if (i % 2 == 0) {
                ou.next = curr;
                ou = curr;
            }
            i++;
            curr = curr.next;
        }
        ji.next = ouHead;
        ou.next = null;

        return jiHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        Solution328 solution328 = new Solution328();
        solution328.oddEvenList(head);
    }
}
