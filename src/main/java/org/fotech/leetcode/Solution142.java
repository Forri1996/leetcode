package org.fotech.leetcode;


import org.fotech.bytedance.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> existed = new HashSet<>();
        while (head != null) {
            if (existed.contains(head)) {
                return head;
            }
            existed.add(head);
            head = head.next;
        }


        return null;
    }
}
