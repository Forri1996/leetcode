package org.fotech.stringandarr;

/**
 * 给你两个字符串 word1 和 word2 。
 * 请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            if (i >= word2.length()) {
                result.append(word1.charAt(i));
                continue;
            }
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if (word2.length() > word1.length()) {
            result.append(word2.substring(word1.length(), word2.length()));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution1768 solution1768 = new Solution1768();
        System.out.println(solution1768.mergeAlternately("",""));
    }
}
