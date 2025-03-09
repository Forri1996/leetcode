package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution143 {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        // 找到中间的结点，把后面的结点改成倒序，然后一对一合并链表
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            curr = curr.next;
        }
        int middle = i / 2;
        ListNode start = new ListNode();
        start.next = head;
        ListNode tail = head;

        for (int m = 0; m < middle; m++) {
            tail = tail.next;
        }
        ListNode start2 = tail.next;
        tail.next = null;
        start2 = reserveList(start2);
        mergeList(start.next, start2);

        head = start.next;
    }

    /**
     * 翻转一个链表
     * @param head
     */
    public ListNode reserveList(ListNode head) {
        ListNode pre = null;
        ListNode curr= head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public void mergeList(ListNode left, ListNode right) {
        List<ListNode> lists = new ArrayList<>();
        ListNode curr= right;
        while (curr != null) {
            lists.add(curr);
            curr= curr.next;
        }

        ListNode lCurr = left;
        int i = 0;
        while (lCurr != null) {
            if (i >= lists.size()) break;

            ListNode insert = lists.get(i);

            ListNode rightC = lCurr.next;
            lCurr.next = insert;
            insert.next = rightC;
            lCurr = rightC;
            i++;
        }
    }
}

