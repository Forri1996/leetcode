package org.fotech.leetcode;


import org.fotech.bytedance.ListNode;

/**
 * 移除链表中倒数第n个节点
 */
public class Solution19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(solution19.removeNthFromEnd(head, 4));;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int totalNum = 1;
        while (curr.next != null) {
            totalNum++;
            curr = curr.next;
        }

        int removeNum = totalNum - n;
        if (removeNum == 0) {
            return head.next;
        }
        curr = head;
        for (int j = 1; j <= totalNum; j++) {
            if (j == removeNum) {
                if (curr.next.next == null) {
                    curr.next = null;
                    return head;
                } else {
                    curr.next = curr.next.next;
                    return head;
                }

            }
            curr = curr.next;
        }

        return curr;
    }
}
