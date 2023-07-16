package org.fotech.leetcode;

import javafx.util.Pair;
import org.fotech.bytedance.TreeNode;

import java.util.*;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 *
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 *
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 */
public class Solution662 {
    // 广度优先遍历，把每一层的左右子树弄出来，然后记录一个最大值
    // 每一层的位置都有计算方法可以计算。所以不需要把node给记录下来。

    public int widthOfBinaryTree(TreeNode root) {
        List<Pair<TreeNode, Integer>> pairList = new ArrayList<>();
        pairList.add(new Pair<>(root, 1));
        int max = 0;
        while (pairList.size() > 0) {
            List<Pair<TreeNode, Integer>> tmpPair = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : pairList) {
                TreeNode node = pair.getKey();
                if (node.left != null) {
                    tmpPair.add(new Pair<>(node.left, pair.getValue() * 2));
                }
                if (node.right != null) {
                    tmpPair.add(new Pair<>(node.right, pair.getValue() * 2 + 1));
                }
            }
            max = Math.max(max, pairList.get(pairList.size() - 1).getValue() - pairList.get(0).getValue());
            pairList = tmpPair;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution662 solution662 = new Solution662();
        System.out.println(solution662.widthOfBinaryTree(new TreeNode(1, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
