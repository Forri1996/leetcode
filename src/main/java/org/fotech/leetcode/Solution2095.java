package org.fotech.leetcode;

import org.fotech.bytedance.ListNode;

public class Solution2095 {
    public ListNode deleteMiddle(ListNode head) {
        int nums = 0;
        ListNode listNode = head;
        while (listNode != null) {
            nums++;
            listNode = listNode.next;
        }
        int middle;
        // 计算中间节点的位置
        if (nums % 2 == 1) {
            middle = (nums + 1) / 2;
        } else {
            middle = (nums + 2) / 2;
        }

        ListNode pre = head;
        ListNode curr = head.next;
        if (curr.next == null) {
            head.next = null;
            return head;
        }
        for (int i = 1; i < middle ; i++) {
            if (i == middle - 1) {
                pre.next = curr.next;
                break;
            }
            pre = curr;
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Solution2095 solution2095 = new Solution2095();
        solution2095.deleteMiddle(head);
        System.out.println(head);
    }
}
