package org.fotech.bytedance;

import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * val不会重复
 */
public class 二叉树最近公共祖先 {
    Map<Integer, TreeNode> parentNode = new HashMap<>();
    List<Integer> visited = new ArrayList<>();


    // 从p节点开始获取到所有的父节点
    // 然后从q节点开始往上走，找到的第一个重合的点就是深度最深的父节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parentNode.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentNode.get(q.val);
        }
        
        return null;
    }
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parentNode.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentNode.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
