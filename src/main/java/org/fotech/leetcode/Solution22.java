package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        int left = n;
        int right = n;
        // 左大于右的话，则不可能满足条件
        dfs(str, left, right, res);
        System.out.println(res.toString());

        return res;
    }

    private void dfs(String str, int left, int right, List<String> res) {
        if (left > right) {
            return;
        }
        if (left == right && left == 0) {
            res.add(str);
        }
        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1, res);
        }
    }


    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(3);
    }

}
