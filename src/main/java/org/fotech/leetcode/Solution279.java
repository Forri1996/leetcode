package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 */
public class Solution279 {
    public int numSquares(int n) {
        // 1 4 9 16
        List<Integer> wqpfArr = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            wqpfArr.add(i*i);
        }
        /**
         * dp[1] = 1
         * dp[2] = 2
         * dp[3] = 3
         * dp[4] = 1
         * dp[5] = dp[4]+dp[1]
         * ……
         * dp[7] = dp[4] + dp[3]
         * dp[8] = dp[4] + dp[4]
         * dp[i] = dp[i-m] + dp[m]
         */
        int[] dp = new int[n+10];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=1;
        if (n <= 4) {
            System.out.println(dp[n]);
            return dp[n];
        }
        for (int i = 5; i <= n; i++) {
            if (wqpfArr.contains(i)) {
                dp[i] = 1;
                continue;
            }
            // 找到离i最近的一个最大平方数
            for (int m = 1; m < wqpfArr.size(); m++) {
                if (wqpfArr.get(m) > i) {
                    break;
                }
                if (dp[i] == 0) {
                    dp[i] = dp[i-wqpfArr.get(m)] + dp[wqpfArr.get(m)];
                } else {
                    dp[i] = Math.min(dp[i], dp[i-wqpfArr.get(m)] + dp[wqpfArr.get(m)]);
                }
            }

        }
        return dp[n];
    }
    public static void main(String[] args) {
        // 1 4 9 16
        List<Integer> wqpfArr = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            wqpfArr.add(i*i);
        }
        int n = 12;
        /**
         * dp[1] = 1
         * dp[2] = 2
         * dp[3] = 3
         * dp[4] = 1
         * dp[5] = dp[4]+dp[1]
         * ……
         * dp[7] = dp[4] + dp[3]
         * dp[8] = dp[4] + dp[4]
         * dp[i] = dp[i-m] + dp[m]
         */
        int[] dp = new int[105];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=1;
        if (n <= 4) {
            System.out.println(dp[n]);
            return;
        }
        for (int i = 5; i <= n; i++) {
            if (wqpfArr.contains(i)) {
                dp[i] = 1;
                continue;
            }
            // 找到离i最近的一个最大平方数
            for (int m = 1; m < wqpfArr.size(); m++) {
                if (wqpfArr.get(m) > i) {
                    break;
                }
                if (dp[i] == 0) {
                    dp[i] = dp[i-wqpfArr.get(m)] + dp[wqpfArr.get(m)];
                } else {
                    dp[i] = Math.min(dp[i], dp[i-wqpfArr.get(m)] + dp[wqpfArr.get(m)]);
                }
            }

        }
        System.out.println(dp[n]);
    }
}
