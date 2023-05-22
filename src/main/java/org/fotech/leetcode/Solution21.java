package org.fotech.leetcode;


import org.fotech.bytedance.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            }
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution21 s = new Solution21();
        ListNode list1 = new ListNode(1, new ListNode(3));
        ListNode list2 = new ListNode(2, new ListNode(4));
        s.mergeTwoLists(list1, list2);
    }
}
