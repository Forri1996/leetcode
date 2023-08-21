package org.fotech.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class Solution151 {
    public String reverseWords(String s) {
        s = " " + s + " ";
        // 维护一个栈 先进后出
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder tempStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                tempStr.append(s.charAt(i));
            } else if (tempStr.length() > 0) {
                deque.addFirst(tempStr.toString());
                tempStr = new StringBuilder();
            }
        }

        StringBuilder res = new StringBuilder();
        while (deque.size() > 0) {
            res.append(deque.pollFirst()).append(" ");
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords("dfef  "));
    }
}
