package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root) {
        if (root == null) return;
        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
    }
}
