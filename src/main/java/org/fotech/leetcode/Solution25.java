package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义pre为需要翻转的左侧的前一个结点
        ListNode pre = dummy;
        // 定义end和pre一起，带回要左右需要翻转的右侧结点
        ListNode end = dummy;

        while (end.next != null) {
            // 1、先列出链表中需要翻转的第一个区间
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            // 定义起始结点为pre
            ListNode start = pre.next;
            // 保存右侧结点的next指针，用于翻转后与下一个区间相连
            ListNode next = end.next;
            // 将右侧结点的next指针设置为null，相当于把链表截断
            end.next = null;
            // 翻转截断后的链表
            pre.next = reverse(start);
            // 此时的左侧结点变成了右侧结点，将其与截断后的右侧链表连上
            start.next = next;
            // pre变成了右侧结点，相当于之前的dummy
            pre = start;
            // end同理
            end = pre;
        }

        return dummy.next;
    }

    /**
     * 翻转一个链表
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        // 链表翻转后的左侧结点的next为null
        ListNode pre = null;
        // 当前指针位置，curr
        ListNode curr = head;
        while (curr != null) {
            // 暂存next
            ListNode next = curr.next;
            // 将现在curr指向右边的指针，改成指向左边
            curr.next = pre;
            // 左侧结点向前移动
            pre = curr;
            // 当前指针向后移动
            curr = next;
        }
        // pre一直向前移动，最终变成了head
        return pre;
    }
}
