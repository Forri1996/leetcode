package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 中序遍历, 遍历k次
 */
public class Solution230 {
    static int res, k;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        k = 1;
        dfs(treeNode);
        System.out.println(res);
    }

    private static void dfs(TreeNode treeNode) {
        if (treeNode == null) return;
        dfs(treeNode.left);
        if (k == 0) return;
        if (--k == 0) res = treeNode.val;
        dfs(treeNode.right);
    }
}
