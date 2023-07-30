package org.fotech.leetcode;

/**
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 *
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 */
public class Solution1071 {

    public static void main(String[] args) {
        Solution1071 solution1071 = new Solution1071();
        System.out.println(solution1071.gcdOfStrings("abababab", "abab"));;
    }
    public String gcdOfStrings(String str1, String str2) {
        if (isGcd(str1, str2)) return str2;
        for (int i = str2.length(); i >=0 ; i--) {
            if (isGcd(str2, str2.substring(0, i+1))) {
                if (isGcd(str1, str2.substring(0, i+1))) {
                    return str2.substring(0, i+1);
                }
            }
        }

        return "";
    }
    // 判断是否是公因子
    private boolean isGcd(String target, String gcd) {
        if (target.length() % gcd.length() != 0) return false;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != gcd.charAt(i % gcd.length())) return false;
        }

        return true;
    }
}
