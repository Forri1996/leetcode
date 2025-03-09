package org.fotech.leetcode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode tn = queue.poll();
                item.add(tn.val);
                if (tn.left != null)queue.add(tn.left);

                if (tn.right != null)queue.add(tn.right);
            }
            result.add(item);
        }

        return result;
    }
}
