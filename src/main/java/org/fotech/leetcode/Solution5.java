package org.fotech.leetcode;

/**
 * 最长回文字串
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindromeV2("aacabdkacaa"));;
    }
//    双指针思路
    public String longestPalindrome(String s) {
        int resultNum = 0;
        String res = "";;
        if (s.length() == 1) {
            return s;
        }
        // 双指针
        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            for (int j = s.length() - 1; j > i; j--) {
                char end = s.charAt(j);
                // 头尾相等，判断一下是否是回文串
                if (start == end) {
                    String subStr = s.substring(i, j+1);
                    boolean isHuiwen = judge(subStr);
                    if (isHuiwen) {
                        if (subStr.length() > res.length()) {
                            res = subStr;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        if (res.equals("")) {
            res = String.valueOf(s.charAt(0));
        }
        return res;
    }
    private boolean judge(String substring) {
        int start = 0;
        int end = substring.length() - 1;
        while (start < end) {
            if (substring.charAt(start) == substring.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

//    动态规划
    public String longestPalindromeV2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // 填充dp数组++
        // 从回文串长度为2开始遍历
        for (int length = 2; length <= s.length(); length++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + length - 1;
                if (j >= s.length()) continue;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }


        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    if (max.length() < j - i + 1) {
                        max = s.substring(i, j+1);
                    }
                }
            }
        }

        return max;
    }
}
