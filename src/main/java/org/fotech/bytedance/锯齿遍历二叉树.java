package org.fotech.bytedance;

import java.util.*;

public class 锯齿遍历二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(zigzagLevelOrder(treeNode));

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> resItem = new ArrayList<>();
            int total = treeNodeQueue.size();
            for (int i = 0; i < total; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                resItem.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            result.add(resItem);
        }
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }
}
