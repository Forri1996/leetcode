package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, list1);
        }


        List<Integer> list2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, list2);
        }

        return list1.equals(list2);
    }


    private void dfs(TreeNode node, List<Integer> intList) {
        if (node.left == null && node.right == null) {
            intList.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, intList);
            }
            if (node.right != null) {
                dfs(node.right, intList);
            }
        }

    }
}
