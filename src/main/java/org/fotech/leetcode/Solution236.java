package org.fotech.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”


 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 记录每个节点的父节点map
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);
        TreeNode p1 = p;
        TreeNode q1 = q;
        while (map.get(p1) != null && map.get(q1) != null) {
            if (map.get(p1) == map.get(q1)) {
                return map.get(p1);
            }  else {
                p1 = map.get(p1);
                q1 = map.get(q1);
            }
        }
        TreeNode p2 = p;
        TreeNode q2 = q;
        while (map.get(p2) != null) {
            if (map.get(p2) == q2) {
                return q2;
            } else {
                p2 = map.get(p2);
            }
        }
        TreeNode p3 = p;
        TreeNode q3 = q;
        while (map.get(q3) != null) {
            if (map.get(q3) == p3) {
                return p3;
            } else {
                q3 = map.get(q3);
            }
        }

        // 然后找到这个list不相等的第一个，那么前一个节点就是祖先
        return null;
    }
    public void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        map.put(node, parent);
        dfs(node.left, node, map);
        dfs(node.right, node, map);
    }
}
