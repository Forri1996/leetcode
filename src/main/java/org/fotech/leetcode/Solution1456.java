package org.fotech.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class Solution1456 {
    Set<String> yuanyin = new HashSet<>();
    public int maxVowels(String s, int k) {

        yuanyin.add("a");
        yuanyin.add("e");
        yuanyin.add("i");
        yuanyin.add("o");
        yuanyin.add("u");
        int num = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (isYuanyin(s.charAt(i))) {
                num++;
            }
        }
        max = num;
        for (int i = k; i < s.length(); i++) {
            if (isYuanyin(s.charAt(i))) {
                num++;
            }
            if (isYuanyin(s.charAt(i-k))) {
                num--;
            }
            max = Math.max(num,max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution1456 solution1456 = new Solution1456();
        System.out.println(solution1456.maxVowels("tryhard", 4));;
    }

    private boolean isYuanyin(char m) {
        return yuanyin.contains(String.valueOf(m));
    }
}
