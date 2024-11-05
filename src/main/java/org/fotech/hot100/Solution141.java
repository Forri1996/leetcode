package org.fotech.hot100;

import org.fotech.LinkNode;
import org.fotech.bytedance.ListNode;

public class Solution141 {

    /**
     * 快慢指针环形判断
     * @param node
     * @return
     */
    public boolean circle(ListNode node) {
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != slow) {

            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }
}
