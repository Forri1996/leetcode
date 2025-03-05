package org.fotech.leetcode;

public class Solution70 {
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        if (n < 4) return n;
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
