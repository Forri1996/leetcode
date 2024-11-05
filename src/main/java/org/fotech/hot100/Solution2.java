package org.fotech.hot100;

import org.fotech.LinkNode;

/**
 * 链表形式的两数相加
 */
public class Solution2 {
    private LinkNode add(LinkNode l1, LinkNode l2) {
        LinkNode head = null;
        LinkNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int m1 = l1 == null ? 0 : l1.val;
            int m2 = l2 == null ? 0 :l2.val;
            int m =m1 + m2 + carry;
            carry = m / 10;
            if (head == null) {
                head = tail = new LinkNode(m % 10);
            } else {
                tail.next = new LinkNode(m % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head;
    }
}
