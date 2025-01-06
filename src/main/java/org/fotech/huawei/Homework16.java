package org.fotech.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 01背包问题：

 有N种物品，每种物品只有一个，第 i 个物品的重量为 wi，价值为pi，另外还有一个承重为W的背包，问该背包在不超载的情况下，装入物品的最大价值是多少?
 */
public class Homework16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer W = Integer.parseInt(sc.nextLine());
        Integer[] weight = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] value = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        /**
         * dp[i][j] = m 代表前i个物品，称重为j的时候，装入的物品的最大值。
         */
        int[][] dp = new int[weight.length+1][W+1];
        dp[0][0] = 0;
        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                // 看当前的weight放不放得进背包
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j-weight[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp);
    }
}
