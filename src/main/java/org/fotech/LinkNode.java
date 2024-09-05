package org.fotech;

import org.fotech.bytedance.ListNode;

public class LinkNode {
    public int val;
    public LinkNode next;
    LinkNode(){}
    public LinkNode(int val){ this.val  = val;}
    public LinkNode(int val, LinkNode node){ this.val  = val;
        this.next = node;}

}
