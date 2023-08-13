package org.fotech.leetcode;

import java.util.Arrays;

/**
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 *
 */
public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return  false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : word1.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            arr2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] + arr2[i] == 0) continue;

            if (arr1[i]==0 || arr2[i] == 0) return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution1657 solution1657 = new Solution1657();
        solution1657.closeStrings("abc","bac");
    }
}
