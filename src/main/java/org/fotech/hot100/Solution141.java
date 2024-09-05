package org.fotech.hot100;

import org.fotech.LinkNode;

public class Solution141 {

    public boolean circle(LinkNode node) {
        LinkNode fast = node.next;
        LinkNode slow = node;
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
