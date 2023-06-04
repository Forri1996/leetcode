package org.fotech.leetcode;

import org.fotech.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Solution35 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            Node node = new Node(head.val, null);
            node.random = head.random == null ? null : node;
            return node;
        }
        // 先复制一个简单的链表

        // 先new一个头对象
        // 然后遍历curr。每遍历一次，就要new一个新的node，然后赋值val给新的node，然后设置为node。next
        // curr 应该领先head一个
        // 维护一个map，key是老node，value是新的node
        Node curr = head.next;
        Node resultHead = new Node(head.val);
        Node result = resultHead;
        // 老node和新node的映射关系
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(head, resultHead);
        while (curr!= null) {
            Node item = new Node(curr.val);
            nodeMap.put(curr, item);
            resultHead.next = item;
            resultHead = resultHead.next;
            curr = curr.next;
        }
        curr = head;
        resultHead = result;
        while (curr != null) {
            if (curr.random != null) {
                resultHead.random = nodeMap.get(curr.random);
            }
            curr = curr.next;
            resultHead = resultHead.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        Node node1 = new Node(1);
        node1.random = node1;

        Node res = solution35.copyRandomList(node1);
        System.out.println(res);
    }
}
