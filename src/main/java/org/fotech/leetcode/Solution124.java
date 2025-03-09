package org.fotech.leetcode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution124 {
    public static int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int lVal = dfs(root.left);
        int rVal = dfs(root.right);
        ans = Math.max(ans, lVal + rVal + root.val);
        return Math.max(Math.max(lVal, rVal)+root.val, 0);
    }
}
