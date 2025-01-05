package org.fotech.leetcode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution98 {
    static boolean flag = true;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-2147483648);
        Deque<TreeNode> stack = new LinkedList<>();
        int min = Integer.MIN_VALUE;
        while (!stack.isEmpty() || treeNode != null) {
            // 找到最左子树
            while(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            TreeNode left = stack.pop();
            if (min != Integer.MIN_VALUE &&min >= left.val) {
                flag = false;
            }
            min = left.val;
            treeNode = left.right;
        }
        System.out.println(flag);
    }

    private static void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null && treeNode.left.val > treeNode.val) flag = false;
        if (treeNode.right != null && treeNode.right.val < treeNode.val) flag = false;
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
