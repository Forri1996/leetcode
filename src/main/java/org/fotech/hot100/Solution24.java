package org.fotech.hot100;

import org.fotech.LinkNode;
import org.fotech.bytedance.ListNode;

/**
 * 两两交换链表中的元素
 * 把第二个节点的next指向第一个节点
 * 把第一个节点的next指向下一个递归结果
 */
public class Solution24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution24.swapPairs(input);
    }
    public ListNode swapPairs(ListNode l1) {
        if (l1 == null || l1.next == null) {
            return l1;
        }
        ListNode one = l1;
        ListNode two = one.next;
        ListNode three= two.next;
        two.next = one;
        one.next = swapPairs(three);

        return two;
    }
}
