package org.fotech.leetcode;



public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
