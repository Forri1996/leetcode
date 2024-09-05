package org.fotech.hot100;

import org.fotech.LinkNode;

public class Solution24 {
    private LinkNode change(LinkNode l1) {
        if (l1 == null || l1.next == null) {
            return null;
        }
        LinkNode newHead = l1.next;
        l1.next = change(newHead.next);
        newHead.next = l1;
        return newHead;
    }
}
