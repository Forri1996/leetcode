package org.fotech.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

/**
 * 自己实现了双向链表，通过在链表中的位置实现最近无访问的规则。插入删除只要交换在链表中的位置即可
 */
public class LRU实现 {

    public static void main(String[] args) {
        LRU实现 solution146V3 = new LRU实现(2);
        System.out.println(solution146V3.put(2,1));
        System.out.println(solution146V3.put(1,1));
        System.out.println(solution146V3.put(2,3));
        System.out.println(solution146V3.put(4,1));
        System.out.println(solution146V3.get(1));
        System.out.println(solution146V3.get(2));
    }
    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
    }

    private Map<Integer, LinkedNode> cache;
    private Integer capacity;
    private LinkedNode head;
    private LinkedNode tail;

    public LRU实现(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedNode linkedNode = cache.get(key);
            // 移动linkedNode 到链表的头。
            // 并删除在原来的这个位置
            removeNode(linkedNode);
            moveToHead(linkedNode);
            return linkedNode.value;
        } else {
            return -1;
        }
    }


    public Integer put(int key, int value) {
        LinkedNode linkedNode = cache.get(key);
        if (linkedNode == null) {
            if (cache.size() == capacity) {
                cache.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            linkedNode = new LinkedNode();
            linkedNode.key = key;
            linkedNode.value = value;
            moveToHead(linkedNode);
            cache.put(key, linkedNode);
        } else {
            linkedNode.value = value;
            removeNode(linkedNode);
            moveToHead(linkedNode);
        }

        return null;
    }

    private void moveToHead(LinkedNode linkedNode) {
        linkedNode.pre = head;
        linkedNode.next = head.next;
        head.next.pre = linkedNode;
        head.next=linkedNode;

    }

    private void removeNode(LinkedNode linkedNode) {
        linkedNode.pre.next = linkedNode.next;
        linkedNode.next.pre = linkedNode.pre;
    }
}