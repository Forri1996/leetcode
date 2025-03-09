package org.fotech.leetcode;

import apple.laf.JRSUIUtils;

import java.util.*;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int m = queue.size();
            for (int i = 0; i < m; i++) {
                TreeNode treeNode = queue.pollFirst();
                item.add(treeNode.val);
                if (treeNode.left != null) queue.addLast(treeNode.left);
                if (treeNode.right != null) queue.addLast(treeNode.right);
            }
            res.add(item.get(item.size() - 1));
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2, null, new TreeNode(5));
        TreeNode treeNode3 = new TreeNode(3, null, new TreeNode(4));
        TreeNode root = new TreeNode(1, treeNode2, treeNode3);
        Solution199 solution199 = new Solution199();
        solution199.rightSideView(root);
    }


}
