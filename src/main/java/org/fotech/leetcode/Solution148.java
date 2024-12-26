package org.fotech.leetcode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */

import org.fotech.bytedance.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 归并排序
 * 快慢指针找中点 未实现该算法
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        List<Integer> m = new ArrayList<>();
        ListNode root = head;
        while (root != null) {
            m.add(root.val);
            root = root.next;
        }
        List<Integer> sorted = m.stream().sorted().collect(Collectors.toList());
        ListNode newHead = head;
        for (int e : sorted) {
            newHead.val = e;
            newHead = newHead.next;
        }

        return head;
    }
}
