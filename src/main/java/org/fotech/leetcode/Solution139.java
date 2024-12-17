package org.fotech.leetcode;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 */
public class Solution139 {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};

        /**
         * m是单词的长度
         * dp[i] dp[i-m] == true && s.str分割长度=m 或者整个就是一个单词
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int wordLen = word.length();

                if (s.substring(0, i).equals(word)) {
                    dp[i] = true;
                    break;
                }


                if (i-wordLen > 0 && dp[i - wordLen] && s.substring(i-wordLen, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(dp[s.length()]);
    }
}
