package org.fotech.bytedance;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution25 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        Solution25 solution25 = new Solution25();
        System.out.println(solution25.reverseKGroup(listNode, 2));
    }

    // 先写一个反转链表的方法。
    // 循环head，次数达到k次时，把数组割裂。保存头和尾。反转成功后，在连回去。
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0, head);

        return null;
    }
}
