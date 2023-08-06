package org.fotech.leetcode;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int k = 0;
        for (int i = 0; i < t.length(); i++) {
            if (k < s.length() && s.charAt(k) == t.charAt(i)) {
                k++;
            }
        }
        return k == s.length();
    }

    public static void main(String[] args) {
        Solution392 solution392= new Solution392();
        solution392.isSubsequence("abc", "ahbgdc");
    }
}
