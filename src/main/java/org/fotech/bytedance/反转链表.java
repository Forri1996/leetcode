package org.fotech.bytedance;

// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class 反转链表 {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // 保存下一个节点的node
            ListNode next = curr.next;
            // 设置curr的next 为prev。反转了方向
            curr.next = prev;
            // 设置prev为当前。即往前走一位
            prev = curr;
            // 设置curr为next，即往后走一位
            curr = next;
        }
        return prev;
    }
}

/**
 * Definition for singly-linked list.
 * public class bytedance.ListNode {
 *     int val;
 *     bytedance.ListNode next;
 *     bytedance.ListNode() {}
 *     bytedance.ListNode(int val) { this.val = val; }
 *     bytedance.ListNode(int val, bytedance.ListNode next) { this.val = val; this.next = next; }
 * }
 */