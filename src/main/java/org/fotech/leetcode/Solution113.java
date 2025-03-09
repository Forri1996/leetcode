package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        TreeNode t4 = new TreeNode(4, t11, null);
        TreeNode t4_2 = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        TreeNode t8 = new TreeNode(8, new TreeNode(13), t4_2);
        TreeNode root = new TreeNode(5, t4, t8);
        Solution113 solution113 = new Solution113();
        solution113.pathSum(root,22);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        dfs(root, targetSum, result, item);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> item) {
        if (root == null) return;

        item.add(root.val);
        if (root.left == null && root.right == null && sum(item) == targetSum) {
            result.add(new ArrayList<>(item));
        }
        dfs(root.left, targetSum, result, item);
        dfs(root.right, targetSum, result, item);
        item.remove(item.size() - 1);
    }

    private int sum(List<Integer> item) {
        int res = 0;
        for (Integer integer : item) {
            res += integer;
        }

        return res;
    }
}
